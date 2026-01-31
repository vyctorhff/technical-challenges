package br.com.challenge.user_shopping_batch.infra.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("TB_FILE_CONFIG")
public record FileConfigEntity (
        @Id
        Long id,
        @Column("ID_USER")
        Long idUser,
        @Column("NM_PATH_FTP")
        String pathFtp,
        @Column("NM_FILE_NAME")
        String fileName
) {}
