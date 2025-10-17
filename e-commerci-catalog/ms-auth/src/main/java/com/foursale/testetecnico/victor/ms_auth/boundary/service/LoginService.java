package com.foursale.testetecnico.victor.ms_auth.boundary.service;

import com.foursale.testetecnico.victor.ms_auth.boundary.http.dtos.LoginRequestDTO;
import com.foursale.testetecnico.victor.ms_auth.boundary.http.dtos.TokenResponseDTO;
import com.foursale.testetecnico.victor.ms_auth.boundary.security.model.UserAuthentication;
import com.foursale.testetecnico.victor.ms_auth.core.model.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public TokenResponseDTO login(LoginRequestDTO dto) {
        var user = new UsernamePasswordAuthenticationToken(dto.nome(), dto.password());
        var authenticate = this.authenticationManager.authenticate(user);

        UserAuthentication principal = (UserAuthentication) authenticate.getPrincipal();
        Usuario userEntity = principal.getUser();

        var token = tokenService.generate(userEntity);
        var refresh = tokenService.createRefresh(userEntity, token);

        return TokenResponseDTO.createWithNow(token, refresh.getRefresh());
    }
}