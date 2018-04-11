package com.courses.demo.controllers;

import com.courses.demo.model.User;
import com.courses.demo.services.UserService;
import com.courses.demo.validations.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService;
    private UserValidator validator;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, BindingResult bindingResult)
    {
        validator.validate(user, bindingResult);
        userService.save(user);
        return "hello";
    }
    @RequestMapping("/")
    public String atartPage()
    {
        return "home";
    }
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUp()
    {
        ModelAndView model = new ModelAndView("signup");
        User user = new User();
        user.setUsername("IOIOIOIIIO");
        model.addObject("user", user);
        return model;
    }
    @ModelAttribute("user")
    public User populateUser()
    {
        return new User();
    }
    @Autowired
    public void setUserService(UserService userService )
    {
        this.userService = userService;
    }
    @Autowired
    public void setValidator(UserValidator validator)
    {
        this.validator = validator;
    }

}
