package com.example.application.dal.repository;

import com.example.application.dal.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(
            value = "SELECT * FROM subjects WHERE ?1 IN (subjects.user_subjects)",
            nativeQuery = true)
    List<Subject> getTeacherSubjects(Integer userId);

    @Query(
            value = "SELECT * FROM subjects WHERE ?1 IN (subjects.user_subjects)",
            nativeQuery = true)
    List<Subject> getStudentSubjects(Integer userId);

}
