package com.example.application.dto.user.teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherCreate {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String position;
}
