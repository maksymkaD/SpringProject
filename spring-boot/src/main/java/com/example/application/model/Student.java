package com.example.application.model;

import com.example.application.dto.StudentDTO;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Students")
public class Student {
    @Id @PrimaryKeyJoinColumn
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "facultyId")
    private Integer facultyId;
    @Column(name = "yearOfStudy")
    private Integer yearOfStudy;

    public Student() {}

    public Student(Integer id, String email, String password, String firstName,
                   String lastName, Integer facultyId, Integer yearOfStudy) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyId = facultyId;
        this.yearOfStudy = yearOfStudy;
    }
}
