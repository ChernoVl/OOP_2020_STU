package sk.stuba.fei.uim.oop.eshop.user.service;

import org.apache.commons.codec.digest.DigestUtils;
import sk.stuba.fei.uim.oop.eshop.user.domain.User;

import java.util.HashMap;
import java.util.Map;

public class LoginPasswordUserService implements UserService, AuthorisationService {

    private Map<String, User> users;

    public LoginPasswordUserService() {
        users = new HashMap<>();
    }

    @Override
    public User register(String email, String password, String name, String surname) {
        User user = new User(name, surname, email, hash(password));
        users.put(email, user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

    @Override
    public boolean logIn(String email, String password) {
        User user = users.get(email);
        if (user == null) {
            return false;
        }

        return user.getPassword().equals(hash(password));
    }

    protected String hash(String word) {
        return DigestUtils.sha256Hex(word);
    }
}
