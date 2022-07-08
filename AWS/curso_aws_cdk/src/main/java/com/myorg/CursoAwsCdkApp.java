package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;

import java.util.Arrays;

public class CursoAwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        // vpc
        VpcStack vpc = new VpcStack(app, "Vpc");

        // cluster
        ClusterStack cluster = new ClusterStack(app, "Cluster", vpc.getVpc());
        cluster.addDependency(vpc);

        // DB - RDS
        RdsStack rdsStack = new RdsStack(app, "Rds", vpc.getVpc());
        rdsStack.addDependency(vpc);

        // add SNS
        SnsStack snsStack = new SnsStack(app, "Sns");

        // service 01
        Service01Stack service01Stack = new Service01Stack(app, "Service01",
                                                            cluster.getCluster(),
                                                            snsStack.getProductEventsTopic());
        service01Stack.addDependency(cluster);
        service01Stack.addDependency(rdsStack);
        service01Stack.addDependency(snsStack);

        app.synth();
    }
}

