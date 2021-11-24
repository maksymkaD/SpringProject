package com.example.application.crud.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.application.crud.model.User;

import java.util.Set;

@Validated
@Getter
@Setter
@Entity
@Table (name = "subjects")
public class Subject {
    @Id @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY) @NotNull
    private Integer id;
    @Column (name = "name") @NotEmpty @NotNull
    private String name;
    @Column (name = "cathedra_name") @NotEmpty @NotNull
    private String cathedra_name;
    @Column (name = "cathedra_id")
    private Integer cathedraId;

    public Subject() {}

    public Subject(@Valid  Integer id, String name, Integer cathedraId) {
        this.id = id;
        this.name = name;
        this.cathedraId = cathedraId;
    }

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
//    private Set<User> teachers;
//
//    public Set<User> getTeachers() {
//        return teachers;
//    }
//
//    public void setTeachers(Set<User> teachers) {
//        this.teachers = teachers;
//    }
//
//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
//    private Set<User> students;
//
//    public Set<User> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<User> students) {
//        this.students = students;
//    }
}
