package com.example.application.crud.controller;

import com.example.application.crud.model.User;
import com.example.application.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/students")
    public String getStudents(Model model, Principal principal) {
        List<User> students = userService.getUsers("student");
        model.addAttribute("students", students);
        System.out.println(students);

        return "users/students/list";
    }

    @GetMapping("/teachers")
    public String getTeachers(Model model, Principal principal) {
        List<User> teachers = userService.getUsers("teacher");
        model.addAttribute("teachers", teachers);

        return "users/teachers/list";
    }

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
    public void createTeacher(@RequestBody User user){
        userService.createTeacher(user);
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
