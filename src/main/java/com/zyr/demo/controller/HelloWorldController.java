package com.zyr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //@RequestMapping(value = "my", method = RequestMethod.GET)
    @GetMapping("my")
    public String say() {
        return "Hello World!";
    }
}
