package com.courses.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.net.Authenticator;

public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedUserName() {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return details.getUsername();
    }

    @Override
    public void autoLogin(String userName, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(authenticationToken);
        if (authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

    }
}
