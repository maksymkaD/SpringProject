package com.example.application.dal.repository;

import com.example.application.dal.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(
            value = "SELECT * FROM subjects INNER JOIN user_subjects ON subjects.id = user_subjects.subject_id WHERE user_subjects.user_id = ?1",
            nativeQuery = true)
    List<Subject> getUserSubjects(Integer userId);
}
