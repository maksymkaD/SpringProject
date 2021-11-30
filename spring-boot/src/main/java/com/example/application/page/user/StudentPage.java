package com.example.application.page.user;

import com.example.application.dal.model.User;
import com.example.application.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentPage {
    @Autowired
    private UserService userService;

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<User> students = userService.getUsers("student");
        model.addAttribute("students", students);

        return "users/students/list";
    }
}
