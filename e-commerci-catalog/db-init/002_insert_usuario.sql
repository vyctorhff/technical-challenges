INSERT INTO tb_usuario
(id, nome, password, email, cpf)
VALUES
(UUID_TO_BIN(UUID()), 'admin', '$2a$10$nAJ2Cfmr2nT0/vcYaQUD2eX7hZOmYTVp7PzO62ot2/b3WffES8Pf6', 'admin@email.com', '00000000001');


INSERT INTO tb_usuario
(id, nome, password, email, cpf)
VALUES
(UUID_TO_BIN(UUID()), 'user-1', '$2a$10$nAJ2Cfmr2nT0/vcYaQUD2eX7hZOmYTVp7PzO62ot2/b3WffES8Pf6', 'user-1@email.com', '00000000002');

-----------------------------------------------------
--Perfil
INSERT INTO tb_perfil
(id, nome)
VALUES
(UUID_TO_BIN(UUID()), 'admin');

INSERT INTO tb_perfil
(id, nome)
VALUES
(UUID_TO_BIN(UUID()), 'user');

-----------------------------------------------------
--Usuario_perfil
INSERT INTO tb_usuario_perfil
(id, id_perfil, id_usuario)
VALUES
(
    UUID_TO_BIN(UUID()), 
    (SELECT id FROM tb_perfil WHERE nome = "admin"),
    (SELECT id FROM tb_usuario WHERE nome = "admin")
);

INSERT INTO tb_usuario_perfil
(id, id_perfil, id_usuario)
VALUES
(
    UUID_TO_BIN(UUID()), 
    (SELECT id FROM tb_perfil WHERE nome = "user"),
    (SELECT id FROM tb_usuario WHERE nome = "user-1")
);