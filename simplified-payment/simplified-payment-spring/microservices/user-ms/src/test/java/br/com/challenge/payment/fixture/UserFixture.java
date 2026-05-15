package br.com.challenge.payment.fixture;

import br.com.challenge.payment.boundary.repository.entity.Account;
import br.com.challenge.payment.boundary.repository.entity.User;

public class UserFixture {

    public static User createBase() {
        var user = new User();
        user.setName("fist name");

        user.setAccount(new Account());
        user.getAccount().setEmail("email@email.com");
        user.getAccount().setPassword("1231");

        return user;
    }

    public static User createByCnpj(String cnpj) {
        var user = createBase();
        user.setCnpj(cnpj);
        user.setCpf(null);
        return user;
    }

    public static User createByCpf(String cpf) {
        var user = createBase();
        user.setCnpj(null);
        user.setCpf(cpf);
        return user;
    }

    public static User createUserCommon() {
        return createByCpf("00000000001");
    }

    public static User createUserLojist() {
        return createByCnpj("00000000000001");
    }
}
