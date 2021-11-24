//package com.example.application.crud.controller;
//
//
//import com.example.application.crud.model.Subject;
//import com.example.application.crud.model.User;
//import com.example.application.crud.service.SubjectService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
///**
// * Setter Injection
// */
//@RestController
//public class SubjectController {
//    SubjectService subjectService;
//    ModelMapper modelMapper;
//
//    @Autowired
//    public void setSubjectService(SubjectService subjectService) {
//        this.subjectService = subjectService;
//    }
//
//    @Autowired
//    public void setModelMapper(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }
//
//    @GetMapping("/subjects")
//    public String getSubjects(Model model, Principal principal) {
//        List<Subject> subjects = subjectService.getSubjects();
//        model.addAttribute("subjects", subjects);
//
//        return "subjects/list";
//    }
//
//    @GetMapping("/subjects/{id}")
//    public String getSubject(@PathVariable("id") int id, Model model, Principal principal) {
//        Optional<Subject> user = subjectService.getSubject(id);
//        model.addAttribute("user", user);
//
//        return "subjects/subject";
//    }
//
//    @PostMapping(path = "/subjects")
//    public void createSubject(@RequestBody Subject s){
//        subjectService.createSubject(s);
//    }
//
//
//    @DeleteMapping("/subjects")
//    public void deleteSubject(@PathVariable("id") int id, Model model, Principal principal) {
//        subjectService.deleteSubject(id);
//    }
//
//}
