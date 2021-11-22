package com.example.application.controller;

import com.example.application.dto.StudentDTO;
import com.example.application.dto.SubjectDTO;
import com.example.application.model.Student;
import com.example.application.model.Subject;
import com.example.application.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Setter Injection
 */
@RestController
public class SubjectController {
    SubjectService subjectService;
    ModelMapper modelMapper;

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @GetMapping("/subjects")
    public List<SubjectDTO> getAllStudents() {

        List<Subject> teachers = subjectService.getAllSubjects();

        return teachers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/subject/{id}")
    public SubjectDTO getStudent(@PathVariable("id") long id) {
        Optional<Subject> subject = subjectService.getSubject(id);
        return convertToDto(subject.get());
    }

    @PostMapping(path = "/admin/subjects")
    public void createStudent(@RequestBody Subject subject){
        subjectService.createSubject(subject);
    }

    @DeleteMapping("/admin/subjects")
    public void deleteStudent(@RequestBody Subject subject) {
        subjectService.deleteSubject(subject);
    }

    private SubjectDTO convertToDto(Subject subject) {
        return modelMapper.map(subject, SubjectDTO.class);
    }
}
