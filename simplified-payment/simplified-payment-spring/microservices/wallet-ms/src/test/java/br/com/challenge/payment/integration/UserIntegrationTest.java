package br.com.challenge.payment.integration;

import br.com.challenge.payment.boundary.http.dto.UserResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.EntityExchangeResult;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureRestTestClient
public class UserIntegrationTest {

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void shouldTest() {
        EntityExchangeResult<UserResponseDTO> result = restTestClient
                .get()
                .uri("/v1/user/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(UserResponseDTO.class)
                .returnResult();

        assertNotNull(result);

        UserResponseDTO dto = result.getResponseBody();
        assertEquals(1, dto.id());
        assertEquals("aa-bb-cc-xx", dto.externalId());
    }
}
