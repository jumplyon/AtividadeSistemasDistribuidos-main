CREATE TABLE "product" (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo SMALLINT UNIQUE,
    preco NUMERIC(10, 2) NOT NULL,
    categoria_id INTEGER,

    CONSTRAINT fk_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES category(id)
);