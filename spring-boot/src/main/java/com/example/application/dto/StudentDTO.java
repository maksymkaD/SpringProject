package com.example.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer facultyId;
    private Integer yearOfStudy;
}
