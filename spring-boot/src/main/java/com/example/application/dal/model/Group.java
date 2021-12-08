package com.example.application.dal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.List;
@Validated
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "subject") @NotBlank
    private String subject;

    @Column (name = "number") //group number
    private int number;

    @Column (name = "users")
    private List<User> studentsInGroup;

    public Group(String subject, Integer number) {
       this.subject = subject;
       this.number = number;

    }

    public Group()
    {
        this.subject = "NaN";
        this.number = 0;
    }

    @ManyToMany
    @JoinTable(
            name = "user_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    Set<Group> userGroups;
}
