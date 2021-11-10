package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
@Entity
@Table(name = "StGroups")
public class StGroup {

    @Id @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "subjectId")  @NotNull
    private Integer subjectId;

    public StGroup() {
    }

    public StGroup(@Valid  Integer id, Integer subjectId) {
        this.id = id;
        this.subjectId = subjectId;
    }
}



