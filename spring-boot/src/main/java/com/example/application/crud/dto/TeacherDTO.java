package com.example.application.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String position; // junior professor | senior professor etc.
}
