package br.com.challenge.payment.core.service;

import br.com.challenge.payment.boundary.http.dto.UserListRequestDTO;
import br.com.challenge.payment.boundary.http.dto.UserResponseDTO;
import br.com.challenge.payment.boundary.repository.UserRepository;
import br.com.challenge.payment.boundary.repository.entity.User;
import br.com.challenge.payment.core.exception.FindUserException;
import br.com.challenge.payment.core.validation.FindUserValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final FindUserValidation validation;

    private final UserRepository userRepository;

    public User findById(Integer id) {
        log.info("Find user: [id={}]", id);

        this.validation.findByIdValidation(id);

        return this.userRepository.findById(id)
                .orElseThrow(() -> new FindUserException("Fail to find by id"));
    }

    public List<User> findByIds(UserListRequestDTO dto) {
        log.info("Find users by ids: [id={}]", dto.ids().toArray());
        return dto.ids().stream()
                .map(id -> this.findById(id))
                .toList();
    }
}
