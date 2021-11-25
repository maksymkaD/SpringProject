package com.example.application.controller.user;

import com.example.application.dto.user.student.StudentCreate;
import com.example.application.service.user.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/students")
    public String createTeacher(StudentCreate studentCreate){
        studentService.createStudent(studentCreate);

        return "home";
    }
}
