package com.example.application.controller;

import com.example.application.dal.model.User;
import com.example.application.dto.teacher.TeacherCreate;
import com.example.application.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public String getTeachersPage(Model model) {
        List<User> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        return "teachers/list";
    }

    @GetMapping("/teachers/create")
    public String createTeacherPage(TeacherCreate teacherCreate) {
        return "teachers/create";
    }

    @PostMapping(path = "/teachers")
    public String createTeacher(@Valid @ModelAttribute TeacherCreate teacherCreate, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "teachers/create";
        }

        teacherService.createTeacher(teacherCreate);

        List<User> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        return "teachers/list";
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable("id") int id) {
        teacherService.deleteTeacher(id);
    }
}
