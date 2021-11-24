//package com.example.application.crud.service;
//
//import com.example.application.crud.model.Lesson;
//import com.example.application.crud.repository.LessonRepository;
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
//public class LessonService {
//    @Autowired
//    LessonRepository lessonRepository;
//
//    public List<Lesson> getLessons() {
//        return lessonRepository.getLessons();
//    }
//
//    public Optional<Lesson> getLesson(int id) {
//        return lessonRepository.findById(id);
//    }
//
//    public void createLesson(Lesson lesson) { lessonRepository.save(lesson); }
//
//
//    public void updateLesson(Lesson lesson) { lessonRepository.save(lesson); }
//
//    public void deleteLesson(int id) { lessonRepository.deleteById(id); }
//}
