package com.example.application.dto.teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherUpdateDTO {
    private String email;

    private String password;

    private String name;

    private String lastName;

    private String position;
}
