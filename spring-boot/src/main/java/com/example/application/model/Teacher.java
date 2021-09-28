package com.example.application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String position; // junior professor | senior professor etc.

    public Teacher(Integer id, String email, String password, String firstName,
                   String lastName, String position) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }
}
