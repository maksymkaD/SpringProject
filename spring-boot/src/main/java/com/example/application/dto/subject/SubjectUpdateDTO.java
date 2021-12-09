package com.example.application.dto.subject;

import com.example.application.dal.model.Subject;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SubjectUpdateDTO {
    @NotBlank
    private String name;

    public Subject toSubject(Subject parent){
        String new_name = this.name != null ? this.name : parent.getName();
        parent.setName(new_name);
        return parent;
    }
}