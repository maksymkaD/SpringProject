package com.example.application.controller;

import com.example.application.model.Teacher;
import com.example.application.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Object> getTeacher(@PathVariable("id") long id) {
        return teacherService.getTeacher(id);
    }

    @PostMapping(path = "/teachers")
    public void createTeacher(@RequestBody Teacher teacher){
        teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/teachers")
    public void deleteTeacher(@RequestBody Teacher teacher) {
        teacherService.deleteTeacher(teacher);
    }
}