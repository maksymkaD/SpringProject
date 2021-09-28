package com.example.application.service;

import com.example.application.dao.StudentDao;
import com.example.application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Field Injection
 */
@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }
}
