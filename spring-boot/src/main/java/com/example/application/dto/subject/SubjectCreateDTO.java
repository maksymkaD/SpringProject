package com.example.application.dto.subject;

import com.example.application.dal.model.Subject;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SubjectCreateDTO {
    @NotBlank
    private String name;

    public Subject toSubject(){
        return new Subject(this.name);
    }
}

