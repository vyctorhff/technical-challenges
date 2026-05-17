package br.com.challenge.payment.fixture;

import br.com.challenge.payment.boundary.http.dto.UserListRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class UserListRequestDTOFixture {

    public static UserListRequestDTO create() {
        return new UserListRequestDTO(
                List.of(1,2)
        );
    }

    public static String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(create());
    }

    public static UserListRequestDTO createEmpty() {
        return new UserListRequestDTO(List.of());
    }
}
