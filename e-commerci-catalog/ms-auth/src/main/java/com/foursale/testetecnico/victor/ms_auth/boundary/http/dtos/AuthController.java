package com.foursale.testetecnico.victor.ms_auth.boundary.http.dtos;

import com.foursale.testetecnico.victor.ms_auth.boundary.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    @GetMapping
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        var tokenDTO = loginService.login(dto);
        return ResponseEntity.ok(tokenDTO);
    }
}
