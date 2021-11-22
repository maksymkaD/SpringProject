package com.example.application.controller;

import com.example.application.dto.SubjectDTO;
import com.example.application.dto.TeacherDTO;
import com.example.application.model.Subject;
import com.example.application.model.Teacher;
import com.example.application.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Constructor Injection
 */
@Validated
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

    @GetMapping("/teacher/{id}")
    public TeacherDTO getStudent(@PathVariable("id") long id) {
        Optional<Teacher> subject = teacherService.getTeacher(id);
        return convertToDto(subject.get());
    }

    @PostMapping(path = "/admin/teachers")
    public void createStudent(@RequestBody Teacher teacher){
        teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/admin/teachers")
    public void deleteStudent(@RequestBody Teacher teacher) {
        teacherService.deleteTeacher(teacher);
    }

    private TeacherDTO convertToDto(@Valid Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }
}
