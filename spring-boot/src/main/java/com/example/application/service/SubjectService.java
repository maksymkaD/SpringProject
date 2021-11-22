package com.example.application.service;

import com.example.application.dao.SubjectDao;
import com.example.application.model.Student;
import com.example.application.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Subject> getSubject(long id) {
        return subjectDao.get(id);
    }

    public void deleteSubject(Subject subject) { subjectDao.delete(subject); }

    public void createSubject(Subject subject) { subjectDao.save(subject); }
}
