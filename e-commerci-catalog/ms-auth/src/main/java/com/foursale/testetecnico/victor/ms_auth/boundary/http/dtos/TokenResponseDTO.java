package com.foursale.testetecnico.victor.ms_auth.boundary.http.dtos;

import com.foursale.testetecnico.victor.ms_auth.core.model.Token;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public record TokenResponseDTO(LocalDateTime time, String token, String refresh) {

    public static TokenResponseDTO createWithNow(String token) {
        return new TokenResponseDTO(LocalDateTime.now(), token, StringUtils.EMPTY);
    }

    public static TokenResponseDTO createWithNow(String token, String refresh) {
        return new TokenResponseDTO(LocalDateTime.now(), token, refresh);
    }

    public static TokenResponseDTO createWithNow(Token token) {
        return new TokenResponseDTO(LocalDateTime.now(), token.getToken(), token.getRefresh());
    }
}
