package com.example.application.dto.group;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class GroupCreateDTO {


    private String subjectName;


    private Integer number;

}
