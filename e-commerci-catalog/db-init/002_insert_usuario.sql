INSERT INTO tb_usuario
(id, nome, password, email, cpf)
VALUES
(UUID_TO_BIN(UUID()), 'admin', '', 'admin@email.com', '00000000001');

INSERT INTO tb_usuario
(id, nome, password, email, cpf)
VALUES
(UUID_TO_BIN(UUID()), 'user-1', '', 'user-1@email.com', '00000000002');
