package br.com.challenge.payment.boundary.http;

import br.com.challenge.payment.boundary.http.dto.UserListRequestDTO;
import br.com.challenge.payment.boundary.repository.entity.User;
import br.com.challenge.payment.core.exception.FindUserException;
import br.com.challenge.payment.core.service.UserService;
import br.com.challenge.payment.fixture.UserFixture;
import br.com.challenge.payment.fixture.UserListRequestDTOFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {

    private static final String PATH_ROOT = "/v1/user";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void shouldGetUserSuccessfuly() throws Exception {
        User userCommon = UserFixture.createUserCommon();
        when(userService.findById(1))
                .thenReturn(userCommon);

        String path = PATH_ROOT + "/1";

        ResultActions result =  mockMvc
                .perform(MockMvcRequestBuilders.get(path))
                .andExpect(MockMvcResultMatchers.status().isOk());

        assertNotNull(result.andReturn()
                .getResponse().getContentAsString());
    }

    @Test
    void shouldGetUserWithInvalidId() throws Exception {
        when(userService.findById(any()))
                .thenThrow(FindUserException.class);

        String path = PATH_ROOT + "/-1";
        mockMvc
                .perform(MockMvcRequestBuilders.get(path))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").isNotEmpty());
    }

    @Test
    void shouldGetListUsersSuccessfuly() throws Exception {
        List<User> listUsers = UserFixture.createListUsers();
        when(userService.findByIds(any()))
                .thenReturn(listUsers);

        String path = PATH_ROOT + "/list-by-ids";
        String requestBody = UserListRequestDTOFixture.toJson();

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cpf").value("00000000001"));
    }
}