package br.com.challenge.payment.boundary.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("TB_USER")
@Data
public class User {

    @Id
    private Integer id;

    @Column("ID_EXTERNAL")
    private String idExternal;

    @Column("DS_NAME")
    private String name;

    @Column("CD_CFP")
    private String cpf;

    @Column("CD_CNPJ")
    private String cnpj;

    @Column("NM_PROFILE")
    private UserProfile profile;

    @MappedCollection(idColumn = "ID_USER")
    private Account account;
}
