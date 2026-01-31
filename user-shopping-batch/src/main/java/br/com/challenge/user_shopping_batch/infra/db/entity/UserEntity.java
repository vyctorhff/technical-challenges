package br.com.challenge.user_shopping_batch.infra.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("TB_USER")
public record UserEntity (
        @Id
        Long id,
        @Column("NM_NOME")
        String name,
        @Column("FL_ENABLE")
        Boolean enable,
        @MappedCollection(idColumn = "ID_USER")
        FileConfigEntity config
) {}
