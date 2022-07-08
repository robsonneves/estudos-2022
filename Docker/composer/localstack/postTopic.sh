# Topico TESTE - vai pra fila de request refund
aws --profile localstack --endpoint-url=http://localhost:4566 sns publish --topic-arn arn:aws:sns:us-east-1:000000000000:TESTE --message '{"body": {
        "id": "433bdf03-3580-4584-823f-ec5f93e6c2d8",
        "orderId": "123bdf03-3580-4584-823f-ec5f93e6c2d1",
        "source": "ORDER_CANCELLATION",
        "refund": {
            "amount": 54.70,
            "category": "FULL_REFUND"
        },
        "metadata": {
            "cancellation_id": "643bdf03-3580-4584-823f-ec5f93e6c233",
            "cancellation_requested_event_id": "912bdf03-3580-4584-823f-ec5f93e6c223",
            "cancel_stage": "[PRE-CONFIRMED]",
            "cancel_code": "406",
            "cancel_origin": "CONSUMER",
            "cancel_user": "257bdf03-3580-4584-823f-ec5f93e6c2d4",
            "cancel_reason": "O pedido foi acidental",
            "cancellation_dispute": {
                "reason": "CLIENT_REQUEST_BEFORE_CONFIRMED",
                "is_contestable": "CANCELLATION_IS_NOT_CONTESTABLE"
            },
            "cancellation_ocurrence": {
                "consumer": {
                    "payment_type": "N/A",
                    "financial_ocurrence": "N/A"
                },
                "logistic": {
                    "payment_type": "N/A",
                    "financial_ocurrence": "N/A"
                },
                "restaurant": {
                    "payment_type": "N/A",
                    "financial_ocurrence": "N/A"
                }
            },
            "timeout_event": false
        },
        "createdAt": "2022-06-13T09:12:40.248894Z"
    }}' | cat


# Topico TESTE - vai pra fila de response payment
# aws --profile localstack --endpoint-url=http://localhost:4566 sns publish --topic-arn arn:aws:sns:us-east-1:000000000000:TESTE --message '{"body": {
#         "name": "RefundFailedSchema",
#         "type": "record",
#         "namespace": "com.ifood.paymentrefundworker.adapter.avro.schema.refundrequest",
#         "fields": [
#             {
#                 "name": "eventId",
#                 "type": "string"
#             },
#             {
#                 "name": "aggregateId",
#                 "type": "string"
#             },
#             {
#                 "name": "refundId",
#                 "type": "string"
#             },
#             {
#                 "name": "requestId",
#                 "type": "string"
#             },
#             {
#                 "name": "paymentId",
#                 "type": "string"
#             },
#             {
#                 "name": "paymentProvider",
#                 "type": "string"
#             },
#             {
#                 "name": "payableType",
#                 "type": "string"
#             },
#             {
#                 "name": "amount",
#                 "type": "MonetaryAmountSchema"
#             },
#             {
#                 "name": "destination",
#                 "type": "string"
#             },
#             {
#                 "name": "type",
#                 "type": "string"
#             }
#         ]
#     }}'
