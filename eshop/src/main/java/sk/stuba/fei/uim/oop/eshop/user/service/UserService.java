package sk.stuba.fei.uim.oop.eshop.user.service;

import sk.stuba.fei.uim.oop.eshop.user.domain.User;

public interface UserService {

    User register(String email, String password, String name, String surname);

    User findByEmail(String email);
}
