package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Set;

@Validated
@Getter
@Setter
@Entity
@Table(name = "Students")
public class Student {
    @Id @PrimaryKeyJoinColumn @NotNull @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email") @Email
    private String email;
    @Column(name = "password") @NotEmpty
    private String password;
    @Column(name = "firstName") @NotEmpty
    private String firstName;
    @Column(name = "lastName") @NotEmpty
    private String lastName;
    @Column(name = "facultyId", columnDefinition = "int default 1") @NotEmpty
    private Integer facultyId;
    @Column(name = "yearOfStudy") @Min(1)@Max(4)
    private Integer yearOfStudy;

    public Student() {}

    public Student(@Valid  Integer id, String email, String password, String firstName,
                   String lastName, Integer facultyId, Integer yearOfStudy) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyId = facultyId;
        this.yearOfStudy = yearOfStudy;
    }

    @ManyToMany
    @JoinTable(name="student_groups",
            joinColumns = @JoinColumn(name="student_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="group_id", referencedColumnName="id")
    )
    private Set<StGroup> st_groups;

    public Set<StGroup> getStGroups() {
        return st_groups;
    }

    public void setStGroups(Set<StGroup> st_groups) {
        this.st_groups = st_groups;
    }

    @ManyToMany
    @JoinTable(name="student_subjects",
            joinColumns = @JoinColumn(name="student_id", referencedColumnName="id"),
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
