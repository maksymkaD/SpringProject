package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Validated
@Getter
@Setter
@Entity
@Table(name = "st_groups")
public class StGroup {

    @Id @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "subject_id")  @NotNull
    private Integer subjectId;

    public StGroup() {
    }

    public StGroup(@Valid  Integer id, Integer subjectId) {
        this.id = id;
        this.subjectId = subjectId;
    }


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "st_groups")
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


}



