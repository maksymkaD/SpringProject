package com.example.application.crud.repository;

import com.example.application.crud.model.Lesson;
import com.example.application.crud.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query(
            value = "SELECT * FROM lessons",
            nativeQuery = true)
    List<Lesson> getLessons();
}