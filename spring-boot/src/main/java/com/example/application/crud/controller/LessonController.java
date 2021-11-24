package com.example.application.crud.controller;

import com.example.application.crud.model.Lesson;
import com.example.application.crud.service.LessonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * Setter Injection
 */
@RestController
public class LessonController {
    LessonService lessonService;
    ModelMapper modelMapper;

    @Autowired
    public void setLessonService(LessonService subjectService) {
        this.lessonService = subjectService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/lessons")
    public String getLessons(Model model, Principal principal) {
        List<Lesson> subjects = lessonService.getLessons();
        model.addAttribute("subjects", subjects);

        return "subjects/list";
    }

    @GetMapping("/lessons/{id}")
    public String getLesson(@PathVariable("id") int id, Model model, Principal principal) {
        Optional<Lesson> user = lessonService.getLesson(id);
        model.addAttribute("user", user);

        return "subjects/subject";
    }

    @PostMapping(path = "/lessons")
    public void createLesson(@RequestBody Lesson s){
        lessonService.createLesson(s);
    }


    @DeleteMapping("/lessons")
    public void deleteLesson(@PathVariable("id") int id, Model model, Principal principal) {
        lessonService.deleteLesson(id);
    }

}