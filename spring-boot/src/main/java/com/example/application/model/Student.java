package com.example.application.model;

import com.example.application.dto.StudentDTO;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Validated
@Getter
@Setter
@Entity
@Table(name = "Students")
public class Student {
    @Id @PrimaryKeyJoinColumn @NotNull
    private Integer id;
    @Column(name = "email") @Email
    private String email;
    @Column(name = "password") @NotEmpty
    private String password;
    @Column(name = "firstName") @NotEmpty
    private String firstName;
    @Column(name = "lastName") @NotEmpty
    private String lastName;
    @Column(name = "facultyId") @NotEmpty
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
}
