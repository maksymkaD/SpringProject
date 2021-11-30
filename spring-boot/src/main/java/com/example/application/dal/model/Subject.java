package com.example.application.dal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Validated
@Getter
@Setter
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name") @NotEmpty
    private String name;

    public Subject() {}

    public Subject(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "userSubjects")
    Set<User> users;
}
