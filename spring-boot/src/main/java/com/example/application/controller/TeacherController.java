package com.example.application.controller;

import com.example.application.dal.model.User;
import com.example.application.dto.teacher.TeacherCreateDTO;
import com.example.application.dto.teacher.TeacherUpdateDTO;
import com.example.application.security.MyUserDetails;
import com.example.application.service.TeacherService;
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
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public String getTeachersPage(Model model) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<User> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        model.addAttribute("user_role", user.getRole());

        return "teachers/list";
    }

    @GetMapping("/teachers/lessons")
    public String getTeachersLessonsPage(Model model) {
        List<User> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        return "teachers/list";
    }

    @GetMapping("/teachers/create")
    public String getCreateTeacherPage(TeacherCreateDTO teacherCreateDTO) {
        return "teachers/create";
    }

    @PostMapping(path = "/teachers/create")
    public String createTeacher(@Valid TeacherCreateDTO teacherCreateDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "teachers/create";
        }

        teacherService.createTeacher(teacherCreateDTO);

        List<User> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        return "redirect:/teachers";
    }

    @GetMapping("/teachers/update/{id}")
    public String getUpdateTeacherPage(@PathVariable Integer id, TeacherUpdateDTO teacherUpdateDTO, Model model) {
        Optional<User> teacher = teacherService.getTeacherById(id);

        if (!teacher.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher not found");
        }

        model.addAttribute("teacher", teacher.get());

        return "teachers/update";
    }

    @PostMapping(path = "/teachers/update/{id}")
    public String updateTeacher(@PathVariable("id") int id, @Valid TeacherUpdateDTO teacherUpdateDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            Optional<User> teacher = teacherService.getTeacherById(id);

            if (!teacher.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher not found");
            }

            model.addAttribute("teacher", teacher);

            return "teachers/update";
        }

        teacherService.updateTeacher(id, teacherUpdateDTO);

        List<User> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        return "redirect:/teachers";
    }

    @GetMapping("/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int id, Model model) {
        teacherService.deleteTeacher(id);

        List<User> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        return "redirect:/teachers";
    }
}
