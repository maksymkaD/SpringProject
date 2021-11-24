//package com.example.application.crud.repository;
//
//import com.example.application.crud.model.Subject;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface SubjectRepository extends JpaRepository<Subject, Integer> {
//    @Query(
//            value = "SELECT * FROM subjects",
//            nativeQuery = true)
//    List<Subject> getSubjects();
//}