package com.example.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "StGroups")
public class StGroup {

    @Id @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "subjectId")
    private Integer subjectId;

    public StGroup() {
    }

    public StGroup(Integer id, Integer subjectId) {
        this.id = id;
        this.subjectId = subjectId;
    }
}



