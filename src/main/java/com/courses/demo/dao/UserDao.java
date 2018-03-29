package com.courses.demo.dao;

import com.courses.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
