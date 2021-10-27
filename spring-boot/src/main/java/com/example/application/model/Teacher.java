package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id @PrimaryKeyJoinColumn @NotNull
    private Integer id;
    @Column (name = "email") @Email
    private String email;
    @Column (name = "password") @NotEmpty
    private String password;
    @Column (name = "firstName") @NotEmpty
    private String firstName;
    @Column (name = "lastName") @NotEmpty
    private String lastName;
    @Column (name = "position") @NotEmpty
    private String position; // junior professor | senior professor etc.

    public Teacher(@Valid  Integer id, String email, String password, String firstName,
                   String lastName, String position) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }


}
