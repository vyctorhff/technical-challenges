package com.foursale.testetecnico.victor.ms_product.boundary.auth;

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
        var user = new UsernamePasswordAuthenticationToken(dto.enrollment(), dto.password());
        var authenticate = this.authenticationManager.authenticate(user);

        UserAuthentication principal = (UserAuthentication) authenticate.getPrincipal();
        User userEntity = principal.getUser();

        var token = tokenService.generate(userEntity);
//        var refresh = tokenService.createRefresh(userEntity, token);

        return TokenResponseDTO.createWithNow(token, "");
    }
}