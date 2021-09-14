package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    void addUser(User user);

    Map<Long, User> findAllUser();

    User findById(long id);
}
