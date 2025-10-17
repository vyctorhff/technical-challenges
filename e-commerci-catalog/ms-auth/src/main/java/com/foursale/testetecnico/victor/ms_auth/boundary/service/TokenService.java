package com.foursale.testetecnico.victor.ms_auth.boundary.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.foursale.testetecnico.victor.ms_auth.boundary.http.dtos.TokenRequestDTO;
import com.foursale.testetecnico.victor.ms_auth.core.model.Token;
import com.foursale.testetecnico.victor.ms_auth.core.model.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {

    public static final int TIME_EXPERATION_IN_HOUR = 2;

    public static final String ISSUER_INFO = "auth-api";

    public static final String ZONE_OFFSET = "-03:00";

    @Value("${security.jwt.secret}")
    private String jwtSecret;

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(jwtSecret);
    }

    private String getIssuer() {
        return ISSUER_INFO;
    }

    private Instant getExpire() {
        return LocalDateTime.now()
                .plusHours(TIME_EXPERATION_IN_HOUR)
                .toInstant(ZoneOffset.of(ZONE_OFFSET));
    }

    public String generate(Usuario user) {
        try {
            return JWT.create()
                    .withIssuer(getIssuer())
                    .withSubject(user.getId().toString())
                    .withExpiresAt(getExpire())
                    .sign(getAlgorithm());
        } catch (JWTCreationException e) {
            throw new IllegalStateException("fail at jwt creation");
        }
    }

    public String validate(String token) {
        try {
            return JWT.require(getAlgorithm())
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return StringUtils.EMPTY;
        }
    }

    public Token createRefresh(Usuario user, String token) {
        throw new NotImplementedException("implementar");
    }

    public Token refresh(TokenRequestDTO dto) {
        throw new NotImplementedException("implementar");
    }

}

