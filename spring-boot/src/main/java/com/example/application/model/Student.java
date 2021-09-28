package com.example.application.model;

import com.example.application.dto.StudentDTO;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class Student {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer facultyId;
    private Integer yearOfStudy;

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
