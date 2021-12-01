package com.example.application.dto.teacher;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class TeacherCreate {
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String position;
}
