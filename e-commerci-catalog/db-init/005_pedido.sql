CREATE TABLE tb_pedido (
    id BINARY(16) PRIMARY KEY,
    id_usuario BINARY(16) NOT NULL,
    status VARCHAR(30) NOT NULL,
    dt_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_tb_pedido_tb_usuario
            FOREIGN KEY (id_usuario)
            REFERENCES tb_usuario (id)
            ON DELETE RESTRICT
);

CREATE TABLE tb_pedido_produto_reservado (
    id BINARY(16) PRIMARY KEY,
    id_pedido BINARY(16) NOT NULL,
    id_produto_reservado BINARY(16) NOT NULL,

    CONSTRAINT fk_tb_pedido_produto_reservado_tb_pedido
            FOREIGN KEY (id_pedido)
            REFERENCES tb_pedido (id)
            ON DELETE RESTRICT,
    
    CONSTRAINT fk_tb_pedido_produto_reservado_tb_produto_reservado
            FOREIGN KEY (id_produto_reservado)
            REFERENCES tb_produto_reservado (id)
            ON DELETE RESTRICT
);