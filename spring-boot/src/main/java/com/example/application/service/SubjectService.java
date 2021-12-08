package com.example.application.service;

import com.example.application.dal.model.Subject;
import com.example.application.dal.model.User;
import com.example.application.dal.repository.SubjectRepository;
import com.example.application.dto.student.StudentCreateDTO;
import com.example.application.dto.student.StudentUpdateDTO;
import com.example.application.dto.subject.SubjectCreateDTO;
import com.example.application.dto.subject.SubjectUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Integer id) {
        return subjectRepository.findById(id);
    }

    public void createSubject(SubjectCreateDTO subjectDTO) {
        subjectRepository.save(subjectDTO.toSubject());
    }

    public void updateSubject(Integer id, SubjectUpdateDTO subjectUpdateDTO) {
        Optional<Subject> subject = getSubjectById(id);

        if (!subject.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subject not found");
        }

        subjectRepository.save(subjectUpdateDTO.toSubject(subject.get()));
    }

    public void deleteSubject(Integer id) {
        subjectRepository.deleteById(id);
    }
}
