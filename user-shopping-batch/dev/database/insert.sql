INSERT INTO TB_USER (NM_NOME, FL_ENABLE) VALUES ('Alice Silva', TRUE);
INSERT INTO TB_USER (NM_NOME, FL_ENABLE) VALUES ('Bruno Oliveira', FALSE);
INSERT INTO TB_USER (NM_NOME, FL_ENABLE) VALUES ('Carla Souza', FALSE);

-- ##########################################################################################
INSERT INTO TB_FILE_CONFIG (ID_USER, NM_PATH_FTP, NM_FILE_NAME)
VALUES (1, '/alice/shopping-logs/', 'file.csv');

INSERT INTO TB_FILE_CONFIG (ID_USER, NM_PATH_FTP, NM_FILE_NAME)
VALUES (2, '/bruno/shopping-logs/', 'file.csv');

INSERT INTO TB_FILE_CONFIG (ID_USER, NM_PATH_FTP, NM_FILE_NAME)
VALUES (3, '/carla/shopping-logs/', 'file.csv');

-- ##########################################################################################
-- ##########################################################################################
