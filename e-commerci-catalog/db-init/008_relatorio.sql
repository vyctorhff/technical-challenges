CREATE TABLE tb_pedido_relatorio (
    id BINARY(16) PRIMARY KEY,
    id_usuario BINARY(16) NOT NULL,
    nome_usuario VARCHAR(150) NOT NULL,
    id_pagamento  BINARY(16) NOT NULL,
    total_pago DECIMAL(10, 2) NOT NULL,
    dt_pedido DATETIME NOT NULL,
    dt_pagamento DATETIME NOT NULL,

    CONSTRAINT fk_tb_pedido_relatorio_tb_usuario
            FOREIGN KEY (id_usuario)
            REFERENCES tb_usuario (id)
            ON DELETE RESTRICT,
    
    CONSTRAINT fk_tb_pedido_relatorio_tb_pagamento
            FOREIGN KEY (id_pagamento)
            REFERENCES tb_pagamento (id)
            ON DELETE RESTRICT
);