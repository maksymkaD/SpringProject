package com.example.application.dao;

import com.example.application.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentDao implements Dao<Student> {
    private List<Student> students = new ArrayList<>();

    public StudentDao() {
        students.add(new Student(1, "john@domain.com", "123", "Jhon", "Deer",
                1, 1999));
        students.add(new Student(2, "susan@domain.com", "345", "Susan", "Deer",
                1, 1999));
    }

    @Override
    public Optional<Student> get(long id) {
        List<Student> matched_list = students.stream().filter(student -> student.getId() == id).collect(Collectors.toList());
        if (matched_list.size() == 0) return Optional.empty();
        return Optional.ofNullable(matched_list.get(0));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void save(Student Student) {
        students.add(Student);
    }

    @Override
    public void update(Student Student, String[] params) {
        //todo
        Student.setFirstName(Objects.requireNonNull(
                params[0], "First name cannot be null"));
        Student.setEmail(Objects.requireNonNull(
                params[1], "Email cannot be null"));

        students.add(Student);
    }

    @Override
    public void delete(Student Student) {
        students.remove(Student);
    }
}
