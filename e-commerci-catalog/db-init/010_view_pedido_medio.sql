CREATE VIEW vw_pedido_medio AS
SELECT
	t.id_usuario AS USUARIO,
	COUNT(t.id_usuario) AS TOTAL_USUARIO,
    SUM(t.total_pago) AS TOTAL_PAGO
FROM
	tb_pedido_relatorio t
GROUP BY
	t.id_usuario
ORDER BY
	SUM(t.total_pago) DESC
;
