package com.example.application.service;

import com.example.application.dao.TeacherDao;
import com.example.application.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    TeacherDao teacherDao;

    public TeacherService(TeacherDao teacherRepository) {
        this.teacherDao = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherDao.getAll();
    }
}
