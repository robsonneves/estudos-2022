# Topico TESTE - vai pra fila de response payment
aws --profile localstack --endpoint-url=http://localhost:4566 sns publish --topic-arn arn:aws:sns:us-east-1:000000000000:RETORNANDO-PAYMENT --message '{"body": {
        "name": "RefundFailedSchema",
        "type": "record",
        "namespace": "com.ifood.paymentrefundworker.adapter.avro.schema.refundrequest",
        "fields": [
            {
                "name": "eventId",
                "type": "string"
            },
            {
                "name": "aggregateId",
                "type": "string"
            },
            {
                "name": "refundId",
                "type": "string"
            },
            {
                "name": "requestId",
                "type": "string"
            },
            {
                "name": "paymentId",
                "type": "string"
            },
            {
                "name": "paymentProvider",
                "type": "string"
            },
            {
                "name": "payableType",
                "type": "string"
            },
            {
                "name": "amount",
                "type": "MonetaryAmountSchema"
            },
            {
                "name": "destination",
                "type": "string"
            },
            {
                "name": "type",
                "type": "string"
            }
        ]
    }}'
