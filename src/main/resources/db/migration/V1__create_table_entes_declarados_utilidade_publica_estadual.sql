CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE entes_declarados_utilidade_publica_estadual (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255),
    code BIGINT,
    law VARCHAR(255)
);