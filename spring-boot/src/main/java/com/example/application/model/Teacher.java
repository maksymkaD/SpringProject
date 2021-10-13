package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id @PrimaryKeyJoinColumn
    private Integer id;
    @Column (name = "email")
    private String email;
    @Column (name = "password")
    private String password;
    @Column (name = "firstName")
    private String firstName;
    @Column (name = "lastName")
    private String lastName;
    @Column (name = "position")
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
