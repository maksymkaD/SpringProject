package com.example.application.crud.pages;

import com.example.application.crud.dto.TeacherDTO;
import com.example.application.crud.model.User;
import com.example.application.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UserPagesController {
    @Autowired
    private UserService userService;

    @GetMapping("/students")
    public String getStudents(Model model, Principal principal) {
        List<User> students = userService.getUsers("student");
        model.addAttribute("students", students);

        return "users/students/list";
    }

    @GetMapping("/teachers")
    public String getTeachersPage(Model model, Principal principal) {
        List<User> teachers = userService.getUsers("teacher");
        model.addAttribute("teachers", teachers);

        return "users/teachers/list";
    }

    @GetMapping("/teachers/create")
    public String createTeacherPage(@Valid TeacherDTO teacherDTO, BindingResult result) {
        return "users/teachers/create";
    }
}
