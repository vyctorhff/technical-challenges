package br.com.challenge.payment.core.service;

import br.com.challenge.payment.boundary.http.dto.UserListRequestDTO;
import br.com.challenge.payment.boundary.repository.UserRepository;
import br.com.challenge.payment.boundary.repository.entity.User;
import br.com.challenge.payment.core.exception.FindUserException;
import br.com.challenge.payment.core.validation.FindUserValidation;
import br.com.challenge.payment.fixture.UserFixture;
import br.com.challenge.payment.fixture.UserListRequestDTOFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private FindUserValidation findUserValidation;

    @Mock
    private UserRepository userRepository;

    @Test
    void shouldFindByIdSuccessfuly() {
        int id = 2;
        User user = UserFixture.createUserCommon();

        when(userRepository.findById(id))
                .thenReturn(Optional.of(user));

        service.findById(id);

        verify(findUserValidation, only())
                .findByIdValidation(id);
    }

    @Test
    void shouldFindByIdNotFound() {
        int id = 1;

        assertThrows(FindUserException.class, () -> {
            service.findById(id);
        });

        verify(findUserValidation, only())
                .findByIdValidation(id);
    }

    @Test
    void shouldFindByIdsSuccessfuly() {
        UserListRequestDTO requestDTO = UserListRequestDTOFixture.create();
        User user = UserFixture.createUserCommon();

        when(userRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(user));

        List<User> userList = service.findByIds(requestDTO);

        assertFalse(userList.isEmpty());
        assertEquals(user.getCpf(), userList.getFirst().getCpf());
    }

    @Test
    void shouldFindByIdsEmpty() {
        List<User> userList = service.findByIds(UserListRequestDTOFixture.createEmpty());

        assertTrue(userList.isEmpty());
    }
}