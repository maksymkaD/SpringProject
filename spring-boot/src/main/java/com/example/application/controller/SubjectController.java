package com.example.application.controller;

import com.example.application.model.Student;
import com.example.application.model.Subject;
import com.example.application.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Setter Injection
 */
@RestController
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<Object> getSubject(@PathVariable("id") long id) {
        return subjectService.getSubject(id);
    }

    @PostMapping(path = "/subjects")
    public void createStudent(@RequestBody Subject subject){
        subjectService.createSubject(subject);
    }

    @DeleteMapping("/subjects")
    public void deleteStudent(@RequestBody Subject subject) {
        subjectService.deleteSubject(subject);
    }
}
