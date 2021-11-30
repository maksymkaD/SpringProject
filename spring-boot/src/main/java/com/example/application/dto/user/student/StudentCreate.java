package com.example.application.dto.user.student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCreate {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String year;
}
