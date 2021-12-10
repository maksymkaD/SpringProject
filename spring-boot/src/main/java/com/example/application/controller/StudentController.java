package com.example.application.controller;

import com.example.application.dal.model.User;
import com.example.application.dto.student.StudentCreateDTO;
import com.example.application.dto.student.StudentUpdateDTO;
import com.example.application.security.MyUserDetails;
import com.example.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getStudentsPage(Model model) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<User> students = studentService.getStudents();
        model.addAttribute("students", students);
        model.addAttribute("user_role", user.getRole());

        return "students/list";
    }

    @GetMapping("/students/create")
    public String getCreateStudentPage(StudentCreateDTO studentCreateDTO) {
        return "students/create";
    }

    @PostMapping(path = "/students/create")
    public String createStudent(@Valid StudentCreateDTO studentCreateDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "students/create";
        }

        studentService.createStudent(studentCreateDTO);

        List<User> students = studentService.getStudents();
        model.addAttribute("students", students);

        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String getUpdateStudentPage(@PathVariable Integer id, StudentUpdateDTO studentUpdateDTO, Model model) {
        Optional<User> student = studentService.getStudentById(id);

        if (!student.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not found");
        }

        model.addAttribute("student", student.get());

        return "students/update";
    }

    @PostMapping(path = "/students/update/{id}")
    public String updateStudent(@PathVariable("id") int id, @Valid StudentUpdateDTO studentUpdateDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            Optional<User> student = studentService.getStudentById(id);

            if (!student.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student not found");
            }

            model.addAttribute("student", student);

            return "students/update";
        }

        studentService.updateStudent(id, studentUpdateDTO);

        List<User> students = studentService.getStudents();
        model.addAttribute("students", students);

        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model) {
        studentService.deleteStudent(id);

        List<User> students = studentService.getStudents();
        model.addAttribute("students", students);

        return "redirect:/students";
    }
}
