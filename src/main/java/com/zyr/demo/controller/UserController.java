package com.zyr.demo.controller;

import com.zyr.demo.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/signUp")  //POST请求方式
    public String signUp(@Valid User user, BindingResult bindingResult) {
        System.out.println("name=" + user.getName());
        System.out.println("age=" + user.getAge());
        System.out.println("password=" + user.getPassword());

        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        return "success";
    }
}
