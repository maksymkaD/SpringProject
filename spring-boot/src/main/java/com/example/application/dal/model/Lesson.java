package com.example.application.dal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Validated
@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "subjectId")  @NotBlank
    private Integer subjectId;

    @Column(name = "groupId") @NotBlank
    private Integer groupId;

    @Column(name = "teacherId")  @NotBlank
    private Integer teacherId;

    @Column(name = "date", columnDefinition = "TIMESTAMP") @NotBlank
    private String date;

    @Column(name = "type") @NotBlank
    private String type; // lecture | practice

    @ManyToOne
    @JoinColumn(name="subject_lessons")
    private Subject lessonSubject;

    public Lesson() {
    }

    public Lesson(Integer subjectId, Integer groupId, Integer teacherId, String date, String type) {
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.date = date;
        this.type = type;
    }
}