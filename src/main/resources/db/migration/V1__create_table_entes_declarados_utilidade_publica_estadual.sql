-- Ative a extensão uuid-ossp (caso não tenha)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE entes_declarados_utilidade_publica_estadual (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    nome VARCHAR(255) NOT NULL,
    code INTEGER NOT NULL,
    law VARCHAR(100) NOT NULL
);
