package com.foursale.testetecnico.victor.ms_product.boundary.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Token {

    private Integer id;

    private User user;

    private String token;

    private String refresh;

    private LocalDateTime createdAt;

    public Token(User user, String token) {
        this.user = user;

        this.refresh = UUID.randomUUID().toString();
        this.token = token;

        this.updateCreateAt();
    }

    public boolean isValid() {
        return LocalDateTime.now().getDayOfYear() == createdAt.getDayOfYear();
    }

    public void updateCreateAt() {
        this.createdAt = LocalDateTime.now();
    }
}
