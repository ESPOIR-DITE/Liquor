package company.com.factory.domain.user;

import company.com.domain.users.Login;
import company.com.util.IdGenerator;

public class LoginFactory {
    public static Login getLogin(String email, String password){
        return new Login.Builder(email)
                .buildToken(IdGenerator.getSuffixFromClassName(LoginFactory.class))
                .buildPassword(password)
                .build();
    }
}
