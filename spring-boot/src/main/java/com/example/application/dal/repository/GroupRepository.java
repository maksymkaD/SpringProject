package com.example.application.dal.repository;

import com.example.application.dal.model.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{
    @Query(
            value = "SELECT * FROM groups",
            nativeQuery = true)
    List<Group> getGroups();

}
