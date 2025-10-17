package com.foursale.testetecnico.victor.ms_auth.boundary.service;

import com.foursale.testetecnico.victor.ms_auth.boundary.repository.UserRepository;
import com.foursale.testetecnico.victor.ms_auth.boundary.repository.dataModel.UsuarioData;
import com.foursale.testetecnico.victor.ms_auth.boundary.security.model.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticatioService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        UsuarioData data = repository.findByNome(nome);
        System.out.println("Encontrei isso:" + data.getNome());
        return new UserAuthentication(data.toModel());
    }

    public void setSpringUserAuth(String enrollment) throws UsernameNotFoundException {
        UserDetails userDetails = this.loadUserByUsername(enrollment);
        var userAuth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(userAuth);
    }
}
