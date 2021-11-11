package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.Update;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Validated
@Table(name = "Lessons")
public class Lesson {
    @Id
    @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY) @NotNull
    private Integer id;
    @Column(name = "subjectId")  @NotNull
    private Integer subjectId;
    @Column(name = "groupId") @NotNull
    private Integer groupId;
    @Column(name = "teacherId")  @NotEmpty
    private Integer teacherId;
    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private String date;
    @Column(name = "type") @NotEmpty
    private String type; // lecture | practice

    public Lesson() {
    }

    public Lesson(@Valid  Integer id, Integer subjectId, Integer groupId, Integer teacherId, String date, String type) {
        this.id = id;
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.date = date;
        this.type = type;
    }

}
