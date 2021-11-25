package com.example.application.crud.controller;

import com.example.application.crud.dto.TeacherDTO;
import com.example.application.crud.model.User;
import com.example.application.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") int id, Model model, Principal principal) {
        Optional<User> user = userService.getUser(id);
        model.addAttribute("user", user);

        return "users/user";
    }

    @PostMapping(path = "/students")
    public void createStudent(@RequestBody User user){
        userService.createStudent(user);
    }

    @PostMapping(path = "/teachers")
    public String createTeacher(TeacherDTO teacherDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "users/teachers/create";
        }
        userService.createTeacher(teacherDTO);

        return "/users/teachers/list";
    }

//    @PutMapping(path = "/students")
//    public void updateStudent(@RequestBody User user , @PathVariable("id") int id){
//        return userService.updateUser();
//    }

    @DeleteMapping("/students")
    public void deleteStudent(@PathVariable("id") int id, Model model, Principal principal) {
        userService.deleteUser(id);
    }
}
