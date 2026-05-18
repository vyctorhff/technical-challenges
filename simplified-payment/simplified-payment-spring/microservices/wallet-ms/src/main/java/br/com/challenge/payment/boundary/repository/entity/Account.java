package br.com.challenge.payment.boundary.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("TB_ACCOUNT")
@Data
public class Account {

    @Id
    private Integer id;

    @Column("NM_EMAIL")
    private String email;

    @Column("VL_PASS")
    private String password;
}
