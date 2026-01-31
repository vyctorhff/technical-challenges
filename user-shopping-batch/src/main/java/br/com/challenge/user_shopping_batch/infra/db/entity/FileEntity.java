package br.com.challenge.user_shopping_batch.infra.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("TB_FILE")
public record FileEntity (
        @Id
        Long id,
        @Column("ID_USER")
        Long idUser,
        @Column("QT_TOTAL_LINES")
        Integer totalLines,
        @Column("DT_CREATE")
        LocalDateTime createAt
) {}
