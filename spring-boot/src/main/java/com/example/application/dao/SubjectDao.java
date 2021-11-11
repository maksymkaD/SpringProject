package com.example.application.dao;

import com.example.application.model.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class SubjectDao implements Dao<Subject> {
    private List<Subject> subjects = new ArrayList<>();

    public SubjectDao() {
        subjects.add(new Subject(1, "Math", 1));
        subjects.add(new Subject(2, "Physics", 2));
    }

    @Override
    public Optional<Subject> get(long id) {
        return Optional.ofNullable(subjects.get((int) id));
    }

    @Override
    public List<Subject> getAll() {
        return subjects;
    }

    @Override
    public void save(Subject Subject) {
        subjects.add(Subject);
    }

    @Override
    public void update(Subject Subject, String[] params) {
        //todo
        Subject.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));

        subjects.add(Subject);
    }

    @Override
    public void delete(Subject Subject) {
        subjects.remove(Subject);
    }
}
