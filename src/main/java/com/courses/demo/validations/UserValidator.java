package com.courses.demo.validations;

import com.courses.demo.model.User;
import com.courses.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator
{
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors)
    {
        User user = (User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getUsername().length() < 8 || user.getUsername().length() > 20) {
            errors.rejectValue("username", "Size.loginForm.username");
        }
        if(userService.findByUserName(user.getUsername())!= null)
        {
            errors.rejectValue("username", "Duplicate.userForm.username=Such username already exist");
        }
   //     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newpassword", "Required");

    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
