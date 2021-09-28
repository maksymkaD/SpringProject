package com.example.application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lesson {
    private Integer id;
    private Integer subjectId;
    private Integer groupId;
    private Integer teacherId;
    private String date;
    private String type; // lecture | practice

    //todo
}
