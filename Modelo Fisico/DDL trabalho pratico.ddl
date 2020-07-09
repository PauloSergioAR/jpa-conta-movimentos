
CREATE TABLE conta (
                numero INTEGER NOT NULL,
                saldo REAL NOT NULL,
                data_abertura DATE NOT NULL,
                nome_titular VARCHAR NOT NULL,
                cpf_titular VARCHAR NOT NULL,
                limite_especial REAL NOT NULL,
                CONSTRAINT numero PRIMARY KEY (numero)
);


CREATE TABLE movimento (
                codigo INTEGER NOT NULL,
                conta_destino INTEGER NOT NULL,
                conta_origem INTEGER NOT NULL,
                valor REAL NOT NULL,
                data DATE NOT NULL,
                tipo VARCHAR NOT NULL,
                impostos REAL NOT NULL,
                CONSTRAINT codigo PRIMARY KEY (codigo, conta_destino, conta_origem)
);


ALTER TABLE movimento ADD CONSTRAINT conta_movimento_fk
FOREIGN KEY (conta_destino)
REFERENCES conta (numero)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE movimento ADD CONSTRAINT conta_movimento_fk1
FOREIGN KEY (conta_origem)
REFERENCES conta (numero)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;