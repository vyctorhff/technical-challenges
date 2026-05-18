package br.com.challenge.payment.boundary.http;

import br.com.challenge.payment.boundary.http.dto.UserListRequestDTO;
import br.com.challenge.payment.boundary.http.dto.UserResponseDTO;
import br.com.challenge.payment.boundary.http.swagger.UserControllerSwagger;
import br.com.challenge.payment.boundary.repository.entity.User;
import br.com.challenge.payment.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController implements UserControllerSwagger {

    private final UserService userService;

    @GetMapping("/{id}")
    @Override
    public UserResponseDTO getUser(@PathVariable("id") Integer id) {
        User user = this.userService.findById(id);
        return UserResponseDTO.fromUser(user);
    }

    @GetMapping("/list-by-ids")
    @Override
    public List<UserResponseDTO> getUsers(@RequestBody UserListRequestDTO dto) {
        return this.userService.findByIds(dto).stream()
                .map(UserResponseDTO::fromUser)
                .toList();
    }
}
