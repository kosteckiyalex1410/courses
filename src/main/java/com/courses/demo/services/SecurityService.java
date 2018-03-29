package com.courses.demo.services;

public interface SecurityService {

    String findLoggedUserName();
    void autoLogin(String userName, String password);

}
