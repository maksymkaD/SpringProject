//package com.example.application.crud.service;
//
//import com.example.application.crud.model.Subject;
//import com.example.application.crud.repository.SubjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * Field Injection
// */
//@Service
//public class SubjectService {
//    @Autowired
//    SubjectRepository subjectRepository;
//
//    public List<Subject> getSubjects() {
//        return subjectRepository.getSubjects();
//    }
//
//    public Optional<Subject> getSubject(int id) {
//        return subjectRepository.findById(id);
//    }
//
//    public void createSubject(Subject subject) { subjectRepository.save(subject); }
//
//
//    public void updateSubject(Subject subject) { subjectRepository.save(subject); }
//
//    public void deleteSubject(int id) { subjectRepository.deleteById(id); }
//}
