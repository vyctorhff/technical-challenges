INSERT INTO tb_user
    (ID, ID_EXTERNAL, DS_NAME, CD_CFP, CD_CNPJ, NM_PROFILE)
VALUES
    (1, 'aa-bb-cc-xx','company-A', NULL, '00000000000001', 'LOJIST'),
    (2, 'aa-bb-cc-yy','jack', '00000000002', NULL, 'COMMON'),
    (3, 'aa-bb-cc-zz','david', '00000000003', NULL, 'COMMON')
;

INSERT INTO TB_ACCOUNT
    (ID_USER, NM_EMAIL, VL_PASS)
VALUES
    (1, 'company-a@email.com', 123),
    (2, 'jack@email.com', 123),
    (3, 'david@email.com', 123)
;