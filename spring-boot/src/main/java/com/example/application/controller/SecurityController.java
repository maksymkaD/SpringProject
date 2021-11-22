package com.example.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

@Validated
@Controller
public class SecurityController {

    @GetMapping("/")
    String home(){
        return "home";
    }

    @GetMapping("/admin")
    String home_admin(){
        return "home_admin";
    }

}