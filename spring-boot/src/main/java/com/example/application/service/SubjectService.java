package com.example.application.service;

import com.example.application.dao.SubjectDao;
import com.example.application.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    SubjectDao subjectDao;

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public List<Subject> getAllSubjects() {
        return subjectDao.getAll();
    }
}
