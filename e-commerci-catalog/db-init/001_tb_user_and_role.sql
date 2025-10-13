CREATE TABLE tb_usuario (
    id BINARY(16) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    cpf VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE tb_perfil (
    id BINARY(16) PRIMARY KEY,
    nome VARCHAR(10) NOT NULL
);

CREATE TABLE tb_usuario_perfil (
    id BINARY(16) PRIMARY KEY,
    id_perfil BINARY(16) NOT NULL,
    id_usuario BINARY(16) NOT NULL,

    CONSTRAINT fk_tb_perfil
        FOREIGN KEY (id_perfil)
        REFERENCES tb_perfil (id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_tb_usuario
            FOREIGN KEY (id_usuario)
            REFERENCES tb_usuario (id)
            ON DELETE RESTRICT
);
