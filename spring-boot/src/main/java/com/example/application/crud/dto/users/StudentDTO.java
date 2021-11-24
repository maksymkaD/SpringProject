package com.example.application.crud.dto.users;

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
    private Integer yearOfStudy;
}
