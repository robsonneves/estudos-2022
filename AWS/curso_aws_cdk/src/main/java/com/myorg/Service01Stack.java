package com.myorg;

import software.amazon.awscdk.*;
import software.amazon.awscdk.services.applicationautoscaling.EnableScalingProps;
import software.amazon.awscdk.services.ecs.*;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.amazon.awscdk.services.elasticloadbalancingv2.HealthCheck;
import software.amazon.awscdk.services.events.targets.SnsTopic;
import software.amazon.awscdk.services.logs.LogGroup;
import software.constructs.Construct;

import java.util.HashMap;
import java.util.Map;

public class Service01Stack extends Stack {
    public Service01Stack(final Construct scope, final String id, Cluster cluster, SnsTopic snsTopic) {
        this(scope, id, null, cluster, snsTopic);
    }

    public Service01Stack(final Construct scope, final String id, final StackProps props, Cluster cluster, SnsTopic snsTopic) {
        super(scope, id, props);

        // Add var de ambiente
        Map<String, String> envVariables = new HashMap<>();
        envVariables.put("SPRING_DATASOURCE_URL", "jdbc:mariadb://" + Fn.importValue("rds-endpoint")
                + ":3306/aws_project01?createDatabaseIfNotExist=true");
        envVariables.put("SPRING_DATASOURCE_USERNAME", "admin");
        envVariables.put("SPRING_DATASOURCE_PASSWORD", Fn.importValue("rds-password"));
        envVariables.put("AWS_REGION", "us-east-1");
        envVariables.put("AWS_SNS_TOPIC_PRODUCT_EVENTS_ARN", snsTopic.getTopic().getTopicArn());

        // Configuracaoes do ALB - fargate
        ApplicationLoadBalancedFargateService service01 =
                ApplicationLoadBalancedFargateService.Builder.create(this, "AL001")
                    .serviceName("service-01")
                        .cluster(cluster)
                        .cpu(512)
                        .desiredCount(2) // quantidade de instancias
                        .listenerPort(8080)
                        .memoryLimitMiB(1024)
                        .taskImageOptions(
                                ApplicationLoadBalancedTaskImageOptions.builder()
                                    .containerName("aws_projeto01")
                                    .image(ContainerImage.fromRegistry("robsonneves/curso_aws_projeto01:1.0.0"))
                                    .containerPort(8080)
                                    .logDriver(LogDriver.awsLogs(AwsLogDriverProps.builder()
                                        .logGroup(LogGroup.Builder.create(this, "Service01LogGroup")
                                            .logGroupName("Service01")
                                            .removalPolicy(RemovalPolicy.DESTROY)
                                            .build())
                                        .streamPrefix("Service01")
                                    .build()))
                                .environment(envVariables) // add var de ambiente
                                .build())
                        .publicLoadBalancer(true)
                        .build();

        // configuracao do target group , monitoramento da app
        service01.getTargetGroup().configureHealthCheck(
                new HealthCheck.Builder()
                    .path("/actuator/health")
                    .port("8080")
                    .healthyHttpCodes("200")
                    .build());

        ScalableTaskCount scalableTaskCount = service01.getService().autoScaleTaskCount(
                EnableScalingProps.builder()
                        .minCapacity(2)
                        .maxCapacity(4)
                        .build());

        scalableTaskCount.scaleOnCpuUtilization(
                "Service01AutoScaling",
                CpuUtilizationScalingProps.builder()
                        .targetUtilizationPercent(50)
                        .scaleInCooldown(Duration.seconds(60))
                        .scaleOutCooldown(Duration.seconds(60))
                        .build());

        snsTopic.getTopic().grantPublish(service01.getTaskDefinition().getTaskRole());
    }
}
