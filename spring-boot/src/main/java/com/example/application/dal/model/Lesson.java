package com.example.application.dal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Validated
@Table(name = "Lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "subjectId")  @NotNull
    private Integer subjectId;
    @Column(name = "groupId") @NotNull
    private Integer groupId;
    @Column(name = "teacherId")  @NotNull
    private Integer teacherId;
    @Column(name = "date")  @NotNull
    private String date;
    @Column(name = "type") @NotNull
    private String type; // lecture | practice

    public Lesson() {
    }

    public Lesson(Integer subjectId, Integer groupId, Integer teacherId, String date, String type) {
        this.id = id;
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.date = date;
        this.type = type;
    }


}