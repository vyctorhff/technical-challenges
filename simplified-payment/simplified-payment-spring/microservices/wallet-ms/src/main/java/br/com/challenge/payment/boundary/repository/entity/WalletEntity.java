package br.com.challenge.payment.boundary.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("TB_WALLET")
public class WalletEntity {

    @Id
    private Integer id;

    @Column("ID_USER")
    private String idUser;

    @Column("VL_AMOUNT")
    private BigDecimal amount;

    @Column("DT_CREATE")
    LocalDateTime createAt;

    @Column("DT_UPDATE")
    LocalDateTime updateAt;
}
