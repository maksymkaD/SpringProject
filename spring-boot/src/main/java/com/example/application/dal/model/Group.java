package com.example.application.dal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Set;

@Validated
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="groups_subject")
    private Subject groupSubject;

    @Column (name = "number") //group number
    private Integer number;

    public Group(Subject groupSubject, Integer number) {
       this.groupSubject = groupSubject;
       this.number = number;
    }

    public Group() {

    }

    @ManyToMany
    @JoinTable(
            name = "group_students",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> groupUsers;
}
