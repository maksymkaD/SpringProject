package com.example.application.controller;

import com.example.application.dto.SubjectDTO;
import com.example.application.model.Subject;
import com.example.application.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    private SubjectDTO convertToDto(Subject subject) {
        return modelMapper.map(subject, SubjectDTO.class);
    }
}
