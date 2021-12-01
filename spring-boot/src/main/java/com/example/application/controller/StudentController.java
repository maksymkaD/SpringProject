package com.example.application.controller;

import com.example.application.dal.model.User;
import com.example.application.dto.student.StudentCreateDTO;
import com.example.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<User> students = studentService.getStudents();
        model.addAttribute("students", students);

        return "students/list";
    }

    @GetMapping("/students/{id}")
    public String getStudent(@PathVariable("id") int id, Model model) {
        Optional<User> student = studentService.getStudentById(id);
        model.addAttribute("student", student);

        return "students/details";
    }

    @PostMapping(path = "/students")
    public String createStudent(StudentCreateDTO studentDTO){
        studentService.createStudent(studentDTO);

        return "home";
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
}
