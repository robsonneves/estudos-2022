# Topico TESTE - vai pra fila de request refund
aws --profile localstack --endpoint-url=http://localhost:4566 sns publish --topic-arn arn:aws:sns:us-east-1:000000000000:ENVIANDO-CANCELLATION --message '{"body": {
        "id": "433bdf03-3580-4584-823f-ec5f93e6c2d9",
        "orderId": "123bdf03-3580-4584-823f-ec5f93e6c2d9",
        "source": "ORDER_CANCELLATION",
        "refund": {
            "amount": 54.70,
            "deadlineInMinutes": 1440,
            "category": "FULL_REFUND"
        },
        "metadata": {
            "type": "CANCELLATION",
            "cancellation_id": "643bdf03-3580-4584-823f-ec5f93e6c233"
        },
        "createdAt": "2022-06-13T09:12:40.248894Z"
    }}' | cat
