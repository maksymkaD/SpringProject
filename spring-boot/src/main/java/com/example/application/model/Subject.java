package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "subjects")
    private Set<Teacher> teachers;

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "subjects")
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


}
