package com.example.application.crud.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Validated
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "email") @Email
    private String email;

    @Column (name = "password") @NotEmpty
    private String password;

    @Column (name = "name") @NotEmpty
    private String name;

    /*
        admin, teacher, student
     */
    @Column (name = "role") @NotEmpty
    private String role;

    // student special attribute
    @Column (name = "year")
    private Integer year;

    // teacher special attribute
    @Column (name = "position")
    private String position;


    public User() {}

    public User(String email, String password, String name, String role, Integer year) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.year = year;
    }

    public User(String email, String password, String name, String role, String position) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.position = position;
    }
}
