package com.courses.demo.services;

import com.courses.demo.model.User;

public interface UserService {

    void save(User user);
    User findByUserName(String userName);
}
