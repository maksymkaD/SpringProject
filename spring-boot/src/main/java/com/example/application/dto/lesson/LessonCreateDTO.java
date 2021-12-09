package com.example.application.dto.lesson;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class LessonCreateDTO {

    @NotBlank
    private String date;

    @NotBlank
    private String type;

    @NotNull
    private Integer subjectId;

    @NotNull
    private Integer groupId;

    @NotNull
    private Integer teacherId;

}
