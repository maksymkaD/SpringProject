package com.example.application.controller;

import com.example.application.dto.StudentDTO;
import com.example.application.exceptions.CustomRequestException;
import com.example.application.model.Student;
import com.example.application.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Field Injection
 */
@Validated
@RestController
public class StudentController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {

        List<Student> students = studentService.getAllStudents();

            return students.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());



    }

    private StudentDTO convertToDto(@Valid  Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
}
