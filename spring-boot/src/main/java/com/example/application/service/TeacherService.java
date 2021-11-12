package com.example.application.service;

import com.example.application.exceptions.CustomExceptionHandler;
import com.example.application.exceptions.CustomRequestException;
import com.example.application.model.Teacher;
import com.example.application.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<>(teacherRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getTeacher(long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (!optionalTeacher.isPresent()) {
            CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
            return new ResponseEntity<>(
                    customExceptionHandler.handleException(
                            new CustomRequestException(String.format("Teacher with id %s was not found", id))
                    ), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalTeacher.get(), HttpStatus.OK);
        }
    }

    public void createTeacher(Teacher teacher) { teacherRepository.save(teacher); }

    public void deleteTeacher(Teacher teacher) { teacherRepository.delete(teacher); }
}
