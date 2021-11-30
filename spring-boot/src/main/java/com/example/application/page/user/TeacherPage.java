package com.example.application.page.user;

import com.example.application.dal.model.User;
import com.example.application.dto.user.teacher.TeacherCreate;
import com.example.application.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherPage {
    @Autowired
    private UserService userService;

    @GetMapping("/teachers")
    public String getTeachersPage(Model model) {
        List<User> teachers = userService.getUsers("teacher");
        model.addAttribute("teachers", teachers);

        return "users/teachers/list";
    }

    @GetMapping("/teachers/create")
    public String createTeacherPage(TeacherCreate teacherCreate, BindingResult result) {
        return "users/teachers/create";
    }
}
