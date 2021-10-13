package com.example.application.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "Lessons")
public class Lesson {
    @Id
    @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "subjectId")
    private Integer subjectId;
    @Column(name = "groupId")
    private Integer groupId;
    @Column(name = "teacherId")
    private Integer teacherId;
    @Column(name = "date")
    private String date;
    @Column(name = "type")
    private String type; // lecture | practice

    public Lesson() {
    }

    public Lesson(Integer id, Integer subjectId, Integer groupId, Integer teacherId, String date, String type) {
        this.id = id;
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.date = date;
        this.type = type;
    }


}
