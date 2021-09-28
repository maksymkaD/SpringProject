package com.example.application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject {
    private Integer id;
    private String name;
    private Integer cathedraId;

    public Subject(Integer id, String name, Integer cathedraId) {
        this.id = id;
        this.name = name;
        this.cathedraId = cathedraId;
    }
}
