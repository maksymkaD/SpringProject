package com.example.application.controller.user;

import com.example.application.dal.model.User;
import com.example.application.dto.user.student.StudentCreate;
import com.example.application.service.user.StudentService;
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
        List<User> students = userService.getUsers("student");
        model.addAttribute("students", students);

        return "users/students/list";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        Optional<User> student = studentService.getStudent(id);
        model.addAttribute("student", student);

        return "students/details";
    }

    @PostMapping(path = "/students")
    public String createTeacher(StudentCreate studentCreate){
        studentService.createStudent(studentCreate);

        return "home";
    }

    @DeleteMapping("/users/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
}
