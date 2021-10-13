package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "Subjects")
public class Subject {
    @Id @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "name")
    private String name;
    @Column (name = "cathedraId")
    private Integer cathedraId;

    public Subject() {}

    public Subject(Integer id, String name, Integer cathedraId) {
        this.id = id;
        this.name = name;
        this.cathedraId = cathedraId;
    }
}
