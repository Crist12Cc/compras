-- gestor de base usado postgresql;
-- nombre de la base compras;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

CREATE TABLE comercio_cliente (
	id uuid NOT NULL,
	nombre varchar(255) NULL,
	ubicacion varchar(255) NULL,
	CONSTRAINT comercio_cliente_pkey PRIMARY KEY (id)
);

CREATE TABLE comprador (
	id uuid NOT NULL,
	nombre varchar(255) NULL,
	CONSTRAINT comprador_pkey PRIMARY KEY (id)
);

CREATE TABLE compra (
	id uuid NOT NULL,
	fecha date NULL,
	medio_pago varchar(255) NULL,
	monto_total float8 NULL,
	comercio_cliente_id uuid NULL,
	comprador_id uuid NULL,
	CONSTRAINT compra_medio_pago_check CHECK (((medio_pago)::text = ANY ((ARRAY['EFECTIVO'::character varying, 'TARJETA'::character varying, 'PLAZOS'::character varying])::text[]))),
	CONSTRAINT compra_pkey PRIMARY KEY (id)
);