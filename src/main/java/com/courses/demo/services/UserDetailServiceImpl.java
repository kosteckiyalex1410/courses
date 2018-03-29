package com.courses.demo.services;

import com.courses.demo.dao.UserDao;
import com.courses.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
