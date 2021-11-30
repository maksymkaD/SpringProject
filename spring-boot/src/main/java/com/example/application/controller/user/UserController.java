package com.example.application.controller.user;

import com.example.application.dal.model.User;
import com.example.application.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        Optional<User> user = userService.getUser(id);
        model.addAttribute("user", user);
        return "home";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "home";
    }
}
