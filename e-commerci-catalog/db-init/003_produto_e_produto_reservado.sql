CREATE TABLE tb_produto (
    id BINARY(16) PRIMARY KEY,
    id_categoria BINARY(16) NOT NULL,
    id_estoque BINARY(16) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(400) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    dt_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dt_atualizacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_tb_produto_tb_categoria
        FOREIGN KEY (id_categoria)
        REFERENCES tb_categoria (id)
        ON DELETE RESTRICT,
    
    CONSTRAINT fk_tb_produto_tb_estoque
        FOREIGN KEY (id_estoque)
        REFERENCES tb_estoque (id)
        ON DELETE RESTRICT
);

CREATE TABLE tb_produto_reservado (
    id BINARY(16) PRIMARY KEY,
    nome_categoria BINARY(16) NOT NULL,
    nome VARCHAR(200) NOT NULL,
    descricao VARCHAR(400) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    qt_comprado INTEGER NOT NULL,
    dt_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dt_atualizacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
);
