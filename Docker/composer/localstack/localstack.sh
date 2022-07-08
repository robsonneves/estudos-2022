
# sequencia criacao SQS
aws --endpoint-url=http://localhost:4566 --profile localstack sqs create-queue --queue-name DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-REFUND-REQUEST
aws --endpoint-url=http://localhost:4566 --profile localstack sqs create-queue --queue-name DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-PAYMENT-REFUND-RESPONSE 

aws --endpoint-url=http://localhost:4566 --profile localstack sqs create-queue --queue-name ENVIANDO-PAYMENT
aws --endpoint-url=http://localhost:4566 --profile localstack sqs create-queue --queue-name RETORNANDO-CANCELLATION

aws --endpoint-url=http://localhost:4566 --profile localstack sqs create-queue --queue-name OMS_PAYMENT_REFUND_ORCHESTRATOR_PAYMENT_REFUND_SCHEDULER

# sequencia criacao SNS
aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-REFUND-RESPONSE
aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-PAYMENT-REFUND-REQUEST

aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name ENVIANDO-CANCELLATION
aws --endpoint http://localhost:4566 --profile localstack sns create-topic --name RETORNANDO-PAYMENT

# sequencia criacao SUBSCRIBE
# Fluxo INDO 
aws --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:ENVIANDO-CANCELLATION --protocol --profile localstack sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-REFUND-REQUEST --endpoint-url=http://localhost:4566
aws --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-PAYMENT-REFUND-REQUEST --protocol --profile localstack sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:ENVIANDO-PAYMENT --endpoint-url=http://localhost:4566

# Fluxo RETORNANDO
aws --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:RETORNANDO-PAYMENT --protocol --profile localstack sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-PAYMENT-REFUND-RESPONSE --endpoint-url=http://localhost:4566
aws --profile localstack sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:DEV_OMS-PAYMENT-REFUND-ORCHESTRATOR-REFUND-RESPONSE --protocol --profile localstack sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:RETORNANDO-CANCELLATION --endpoint-url=http://localhost:4566




# SQS que vem de cancellation pra gente -> oms-payment-refund-orchestrator-refund-request
# SNS nosso pra cancellation -> oms-payment-refund-orchestrator-refund-response

# SNS nosso para payment -> oms-payment-refund-orchestrator-payment-refund-request
# SQS de payment pra gente -> oms-payment-refund-orchestrator-payment-refund-response

# Response - resposta 
# Request  - soliciar 

# Substituir Nome
# oms-payment-refund-result