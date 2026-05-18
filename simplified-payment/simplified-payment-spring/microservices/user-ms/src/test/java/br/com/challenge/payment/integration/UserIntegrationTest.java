package br.com.challenge.payment.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest
@AutoConfigureRestTestClient
public class UserIntegrationTest {

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void shouldTest() {
        restTestClient
                .get()
                .uri("/v1/user/1")
                .exchange()
                .expectStatus().isOk();
    }
}
