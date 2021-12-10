package com.example.application.dto.lesson;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class LessonUpdateDTO {
    private Integer subjectId;
    private Integer groupId;
    private Integer teacherId;
    private String date;
    private String type;
}
