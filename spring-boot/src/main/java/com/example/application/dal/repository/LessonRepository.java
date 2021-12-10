package com.example.application.dal.repository;

import com.example.application.dal.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    @Query(
            value = "SELECT * FROM lessons WHERE subjectId = ?1",
            nativeQuery = true)
    List<Lesson> getBySubjectId(Integer subjectId);

    @Query(
            value = "SELECT * FROM lessons WHERE teacherId = ?1",
            nativeQuery = true)
    List<Lesson> getByTeacherId(Integer teacherId);

    @Query(
            value = "SELECT * FROM lessons WHERE groupId = ?1",
            nativeQuery = true)
    List<Lesson> getByGroupId(Integer groupId);

    @Query(
            value = "SELECT * FROM lessons INNER JOIN user_subjects ON lessons.subjectId = user_subjects.subject_id "+
            "WHERE user_subjects.user_id = ?1",
            nativeQuery = true)
    List<Lesson> getLessonsByUserId(Integer userId);
}