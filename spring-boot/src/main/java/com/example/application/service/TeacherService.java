package com.example.application.service;

import com.example.application.dao.TeacherDao;
import com.example.application.model.Subject;
import com.example.application.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    TeacherDao teacherDao;

    public TeacherService(TeacherDao teacherRepository) {
        this.teacherDao = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherDao.getAll();
    }

    public Optional<Teacher> getTeacher(long id) {
        return teacherDao.get(id);
    }

    public void deleteTeacher(Teacher teacher) { teacherDao.delete(teacher); }

    public void createTeacher(Teacher teacher) { teacherDao.save(teacher); }
}
