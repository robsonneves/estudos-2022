--CREATE SCHEMA payment-refund-worker-refund-payment;
-- Creation of consumer table
CREATE TABLE IF NOT EXISTS tb_consumer (
  id_consumer INT NOT NULL CONSTRAINT PK_ID_CONSUMER PRIMARY KEY,
  payment_type varchar(250),
  financial_ocurrence varchar(250)
);

-- Creation of logistic table
CREATE TABLE IF NOT EXISTS tb_logistic (
  id_logistic INT NOT NULL CONSTRAINT PK_ID_LOGISTIC PRIMARY KEY,
  payment_type varchar(250),
  financial_ocurrence varchar(250)
);

-- Creation of restaurant table
CREATE TABLE IF NOT EXISTS tb_restaurant (
  id_restaurant INT NOT NULL CONSTRAINT PK_ID_RESTAUTANT PRIMARY KEY,
  payment_type varchar(250),
  financial_ocurrence varchar(250)
);

-- Creation of cancellation_ocurrence table
CREATE TABLE IF NOT EXISTS tb_cancellation_ocurrence (
  id_cancellation_ocurrence INT NOT NULL CONSTRAINT PK_ID_CANCELLATION_OCURRENCE PRIMARY KEY,
  consumer integer NOT NULL,
  logistic integer NOT NULL,
  restaurant integer NOT NULL,
  FOREIGN KEY (consumer) REFERENCES tb_consumer (id_consumer) ON DELETE CASCADE,
  FOREIGN KEY (logistic) REFERENCES tb_logistic (id_logistic) ON DELETE CASCADE,
  FOREIGN KEY (restaurant) REFERENCES tb_restaurant (id_restaurant) ON DELETE CASCADE
);

-- Creation of cancellation_dispute table
CREATE TABLE IF NOT EXISTS tb_cancellation_dispute (
  id_cancellation_dispute INT NOT NULL CONSTRAINT PK_ID_CANCELLATION_DISPUTE PRIMARY KEY,
  reason varchar(250),
  is_contestable varchar(250)
);

-- Creation of metadata table
CREATE TABLE IF NOT EXISTS tb_metadata (
  id_metadata INT NOT NULL CONSTRAINT PK_ID_METADATA PRIMARY KEY,
  cancellation_id varchar(250),
  cancellation_requested_event_id varchar(250),
  cancel_stage varchar(250),
  cancel_code varchar(250),
  cancel_origin varchar(250),
  cancel_user varchar(250),
  cancel_reason varchar(250),
  cancellation_dispute integer NOT NULL,
  cancellation_ocurrence integer NOT NULL,
  timeout_event boolean,
  FOREIGN KEY (cancellation_dispute) REFERENCES tb_cancellation_dispute (id_cancellation_dispute) ON DELETE CASCADE,
  FOREIGN KEY (cancellation_ocurrence) REFERENCES tb_cancellation_ocurrence (id_cancellation_ocurrence) ON DELETE CASCADE
);

-- Creation of refund table
CREATE TABLE IF NOT EXISTS tb_refund (
  id_refund INT NOT NULL CONSTRAINT PK_ID_REFUND PRIMARY KEY,
  amount float,
  category varchar(250)
);

-- Creation of order table
CREATE TABLE IF NOT EXISTS tb_order_refund (
  id INT NOT NULL,
  orderId varchar(250),
  source_str varchar(250),
  refund int NOT NULL,
  metadata int NOT NULL,
  createdAt varchar(250),
  FOREIGN KEY (refund) REFERENCES tb_refund (id_refund) ON DELETE CASCADE,
  FOREIGN KEY (metadata) REFERENCES tb_metadata (id_metadata) ON DELETE CASCADE
);










-- tabelas refund

-- Creation of order table
CREATE TABLE IF NOT EXISTS tb_order_refund (
  id uuid PRIMARY KEY NOT NULL,
  order_id uuid NOT NULL,
  source varchar(250),
  refund jsonb NOT NULL,
  metadata jsonb NOT NULL,
  created_at varchar(250)
);

-- Create of status table
CREATE TABLE IF NOT EXISTS tb_status (
	id uuid NOT NULL,
	order_id uuid NOT NULL,
	"value" text NOT NULL,
	metadata jsonb NULL,
	"source" text NOT NULL,
	created_at timestamptz NOT NULL
);