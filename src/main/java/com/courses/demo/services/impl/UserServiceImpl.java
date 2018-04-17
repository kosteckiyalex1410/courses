package com.courses.demo.services.impl;

import com.courses.demo.dao.RoleDao;
import com.courses.demo.dao.UserDao;
import com.courses.demo.model.Role;
import com.courses.demo.model.User;
import com.courses.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    private PasswordEncoder encoder;

    private RoleDao roleDao;


    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUsername(userName);
    }

    @Autowired
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Autowired
    public PasswordEncoder getEncoder(PasswordEncoder encoder) {
        return encoder;
    }

    @Autowired
    public void roleDao(RoleDao roleDao)
    {
        this.roleDao = roleDao;
    }
}
