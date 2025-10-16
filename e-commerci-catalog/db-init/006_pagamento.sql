CREATE TABLE tb_forma_pagamento (
    id BINARY(16) PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    dt_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dt_atualizacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_carteira (
    id BINARY(16) PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    cartao VARCHAR(300) NOT NULL,
    dt_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dt_atualizacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_pagamento (
    id BINARY(16) PRIMARY KEY,
    id_forma_pagamento BINARY(16),
    id_pedido_produto_reservado BINARY(16) NOT NULL,
    id_carteira BINARY(16),
    total DECIMAL(10, 2) NOT NULL,
    desconto DECIMAL(10, 2) NOT NULL,
    dt_criacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dt_pagamento DATETIME NOT NULL,

    CONSTRAINT fk_tb_pagamento_tb_forma_pagamento
        FOREIGN KEY (id_forma_pagamento)
        REFERENCES tb_forma_pagamento (id)
        ON DELETE RESTRICT,
    
    CONSTRAINT fk_tb_pagamento_tb_produto_reservado
        FOREIGN KEY (id_pedido_produto_reservado)
        REFERENCES tb_produto_reservado (id)
        ON DELETE RESTRICT,
    
    CONSTRAINT fk_tb_pagamento_tb_carteira
        FOREIGN KEY (id_carteira)
        REFERENCES tb_carteira (id)
        ON DELETE RESTRICT
);
