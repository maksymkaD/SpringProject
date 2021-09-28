package com.example.application.dao;

import com.example.application.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class TeacherDao implements Dao<Teacher> {
    private List<Teacher> teachers = new ArrayList<>();

    public TeacherDao() {
        teachers.add(new Teacher(1, "alice@domain.com", "123", "Alice", "Bob",
                "Junior"));
        teachers.add(new Teacher(1, "bob@domain.com", "123", "Bob", "Alice",
                "Senior"));
    }

    @Override
    public Optional<Teacher> get(long id) {
        return Optional.ofNullable(teachers.get((int) id));
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void save(Teacher Teacher) {
        teachers.add(Teacher);
    }

    @Override
    public void update(Teacher Teacher, String[] params) {
        //todo
        Teacher.setFirstName(Objects.requireNonNull(
                params[0], "First name cannot be null"));
        Teacher.setEmail(Objects.requireNonNull(
                params[1], "Email cannot be null"));

        teachers.add(Teacher);
    }

    @Override
    public void delete(Teacher Teacher) {
        teachers.remove(Teacher);
    }
}
