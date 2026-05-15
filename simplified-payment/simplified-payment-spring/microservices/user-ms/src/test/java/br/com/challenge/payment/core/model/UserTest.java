package br.com.challenge.payment.core.model;

import br.com.challenge.payment.boundary.repository.entity.User;
import br.com.challenge.payment.fixture.UserFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testShouldBeLojist() {
        User user = UserFixture.createUserLojist();
        assertTrue(user.isUserLojist());
    }

    @Test
    void testShouldUserCommon() {
        User user = UserFixture.createUserCommon();
        assertTrue(user.isUserCommon());
    }
}