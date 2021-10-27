package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
@Entity
@Table (name = "Subjects")
public class Subject {
    @Id @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY) @NotNull
    private Integer id;
    @Column (name = "name") @NotEmpty
    private String name;
    @Column (name = "cathedraId") @NotNull
    private Integer cathedraId;

    public Subject() {}

    public Subject(@Valid  Integer id, String name, Integer cathedraId) {
        this.id = id;
        this.name = name;
        this.cathedraId = cathedraId;
    }
}
