package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Validated
@Getter
@Setter
@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id @PrimaryKeyJoinColumn @NotNull @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "email") @Email
    private String email;
    @Column (name = "password") @NotEmpty
    private String password;
    @Column (name = "firstName") @NotEmpty
    private String firstName;
    @Column (name = "lastName") @NotEmpty
    private String lastName;
    @Column (name = "position") @NotEmpty
    private String position; // junior professor | senior professor etc.

    public Teacher() {

    }

    public Teacher(@Valid  Integer id, String email, String password, String firstName,
                   String lastName, String position) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    @ManyToMany
    @JoinTable(name="teacher_subjects",
            joinColumns = @JoinColumn(name="teacher_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="subject_id", referencedColumnName="id")
    )
    private Set<Subject> subjects;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }



}
