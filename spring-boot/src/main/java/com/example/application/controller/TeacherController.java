package com.example.application.controller;

import com.example.application.dto.TeacherDTO;
import com.example.application.model.Teacher;
import com.example.application.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Constructor Injection
 */
@RestController
public class TeacherController {
    TeacherService teacherService;
    ModelMapper modelMapper;

    public TeacherController(TeacherService teacherService, ModelMapper modelMapper) {
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> getAllStudents() {

        List<Teacher> teachers = teacherService.getAllTeachers();

        return teachers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TeacherDTO convertToDto(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }
}
