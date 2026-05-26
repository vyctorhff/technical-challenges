package br.com.challenge.payment.boundary.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("TB_TRANSACTION")
public class TransactionEntity {

    @Id
    private Integer id;

    @Column("ID_USER_SOURCE")
    private String idUserSource;

    @Column("ID_USER_TARGET")
    private String idUserUserTarget;

    @Column("CD_TRANSACTION")
    private String codeTransaction;

    @Column("VL_AMOUNT")
    private BigDecimal amount;

    @Column("ST_STATUS")// TODO: check!
    private TransactionStatusEntity status;

    @Column("DT_CREATE")
    LocalDateTime createAt;
}
