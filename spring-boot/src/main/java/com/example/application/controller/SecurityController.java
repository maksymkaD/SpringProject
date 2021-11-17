package com.example.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@Controller
public class SecurityController {

    @GetMapping("/user")
    String home(){
        return "home";
    }

    @GetMapping("/admin")
    String home_admin(){
        return "home_admin";
    }

}