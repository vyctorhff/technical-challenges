CREATE VIEW vw_top_usuario AS
SELECT
	t.id_usuario,
    SUM(t.total_pago)
FROM
	tb_pedido_relatorio t
GROUP BY
	t.id_usuario
ORDER BY
	SUM(t.total_pago) DESC
;
