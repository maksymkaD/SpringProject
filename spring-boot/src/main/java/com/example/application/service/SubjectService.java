package com.example.application.service;

import com.example.application.exceptions.CustomExceptionHandler;
import com.example.application.exceptions.CustomRequestException;
import com.example.application.model.Student;
import com.example.application.model.Subject;
import com.example.application.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getSubject(long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (!optionalSubject.isPresent()) {
            CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
            return new ResponseEntity<>(
                    customExceptionHandler.handleException(
                            new CustomRequestException(String.format("Subject with id %s was not found", id))
                    ), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalSubject.get(), HttpStatus.OK);
        }
    }

    public void createSubject(Subject subject) { subjectRepository.save(subject); }

    public void deleteSubject(Subject subject) { subjectRepository.delete(subject); }
}
