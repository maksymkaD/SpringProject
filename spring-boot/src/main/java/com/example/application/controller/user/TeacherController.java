package com.example.application.controller.user;

import com.example.application.aspect.LogArguments;
import com.example.application.aspect.LogExecutionTime;
import com.example.application.dto.user.teacher.TeacherCreate;
import com.example.application.service.user.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping(path = "/teachers")
    @LogExecutionTime
    @LogArguments
    public String createTeacher(TeacherCreate teacherCreate, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "users/teachers/create";
        }
        teacherService.createTeacher(teacherCreate);
        return "redirect:/teachers/create";
    }
}
