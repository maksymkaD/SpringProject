package com.example.application.controller;

import com.example.application.dal.model.Group;
import com.example.application.dal.model.Lesson;
import com.example.application.dto.lesson.LessonCreateDTO;
import com.example.application.dto.lesson.LessonUpdateDTO;
import com.example.application.service.GroupService;
import com.example.application.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/lessons")
    public String getLessonsPage(Model model) {
        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);
        return "lessons/list";
    }

    @GetMapping("/lessons/teacher/{id}")
    public String getTeacherLessonsPage(@PathVariable Integer id, Model model) {
        List<Lesson> lessons = lessonService.getLessonsTeacher(id);
        model.addAttribute("lessons", lessons);
        return "lessons/list";
    }

    @GetMapping("/lessons/group/{id}")
    public String getGroupLessonsPage(@PathVariable Integer id, Model model) {
        List<Lesson> lessons = lessonService.getLessonsGroup(id);
        model.addAttribute("lessons", lessons);
        return "lessons/list";
    }

    @GetMapping("/lessons/subject/{id}")
    public String getSubjectLessonsPage(@PathVariable Integer id, Model model) {
        List<Lesson> lessons = lessonService.getLessonsSubject(id);
        model.addAttribute("lessons", lessons);
        return "lessons/list";
    }

    @GetMapping("/lessons/user/{id}")
    public String getUserLessonsPage(@PathVariable Integer id, Model model) {
        List<Lesson> lessons = lessonService.getLessonsByUser(id);
        model.addAttribute("lessons", lessons);
        return "lessons/list";
    }

    @GetMapping("/lessons/create")
    public String getCreateLessonPage(LessonCreateDTO lessonCreateDTO) {
        return "lessons/create";
    }

    @PostMapping(path = "/lessons/create")
    public String createLesson(@Valid LessonCreateDTO lessonCreateDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "lessons/create";
        }

        lessonService.createLesson(lessonCreateDTO);

        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);

        return "redirect:/lessons";
    }

    @GetMapping("/lessons/update/{id}")
    public String getUpdateLessonPage(@PathVariable Integer id, LessonUpdateDTO lessonUpdateDTO, Model model) {
        Optional<Lesson> lesson = lessonService.getLessonById(id);

        if (!lesson.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lesson not found");
        }

        model.addAttribute("lesson", lesson.get());

        return "lessons/update";
    }

    @PostMapping(path = "/lessons/update/{id}")
    public String updateLesson(@PathVariable("id") int id, @Valid LessonUpdateDTO lessonUpdateDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            Optional<Lesson> lesson = lessonService.getLessonById(id);

            if (!lesson.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lesson not found");
            }

            model.addAttribute("lesson", lesson);

            return "lessons/update";
        }

        lessonService.updateLesson(id, lessonUpdateDTO);

        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);

        return "redirect:/lessons";
    }

    @GetMapping("/lessons/delete/{id}")
    public String deleteLesson(@PathVariable("id") int id, Model model) {
        lessonService.deleteLesson(id);

        List<Lesson> lessons = lessonService.getLessons();
        model.addAttribute("lessons", lessons);

        return "redirect:/lessons";
    }
}
