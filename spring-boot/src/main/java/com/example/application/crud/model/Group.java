//package com.example.application.crud.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.validation.annotation.Validated;
//
//import javax.persistence.*;
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
//import java.util.Set;
//
//@Validated
//@Getter
//@Setter
//@Entity
//@Table(name = "student")
//public class Group {
//
//    @Id @PrimaryKeyJoinColumn @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Integer id;
//    @Column(name = "subject_id")  @NotNull
//    private Integer subjectId;
//
//    public Group() {
//    }
//
//    public Group(@Valid  Integer id, Integer subjectId) {
//        this.id = id;
//        this.subjectId = subjectId;
//    }
//
////
////    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
////    private Set<User> students;
////
////    public Set<User> getStudents() {
////        return students;
////    }
////
////    public void setStudents(Set<User> students) {
////        this.students = students;
////    }
//
//
//}
//
//
//
