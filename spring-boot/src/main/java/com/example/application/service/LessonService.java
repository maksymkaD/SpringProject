package com.example.application.service;

import com.example.application.dal.model.Lesson;
import com.example.application.dal.repository.LessonRepository;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.student.StudentCreateDTO;
import com.example.application.dto.lesson.LessonUpdateDTO;
import com.example.application.dto.lesson.LessonCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    LessonRepository lessonRepository;


    public List<Lesson> getLessons() {
        return lessonRepository.findAll();
    }
    public List<Lesson> getLessonsTeacher(Integer teacherId) {
        return lessonRepository.getByTeacherId(teacherId);
    }
    public List<Lesson> getLessonsSubject(Integer subjectId) {
        return lessonRepository.getBySubjectId(subjectId);
    }
    public List<Lesson> getLessonsGroup(Integer groupId) { return lessonRepository.getByGroupId(groupId);  }


    public Optional<Lesson> getLessonById(Integer id) {
        return lessonRepository.findById(id);
    }

    public void createLesson(LessonCreateDTO lessonDTO) {
        Lesson teacher = new Lesson(
                lessonDTO.getSubjectId(),
                lessonDTO.getTeacherId(),
                lessonDTO.getGroupId(),
                lessonDTO.getDate(),
                lessonDTO.getType()
        );

        lessonRepository.save(teacher);
    }

    public void updateLesson(Integer id, LessonUpdateDTO studentUpdateDTO) {
        Optional<Lesson> student = getLessonById(id);

        if (!student.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher not found");
        }

        Lesson lessonToUpdate = student.get();

        String date = studentUpdateDTO.getDate();
        String type = studentUpdateDTO.getType();
        Integer groupId = studentUpdateDTO.getGroupId();
        Integer subjectId = studentUpdateDTO.getSubjectId();
        Integer teacherId = studentUpdateDTO.getTeacherId();

        if (!date.isEmpty()) {
            lessonToUpdate.setDate(date);
        }
        if (!type.isEmpty()) {
            lessonToUpdate.setType(type);
        }
        if (subjectId != null) {
            lessonToUpdate.setSubjectId(subjectId);
        }
        if (teacherId != null) {
            lessonToUpdate.setTeacherId(teacherId);
        }
        if (groupId != null) {
            lessonToUpdate.setGroupId(groupId);
        }

        lessonRepository.save(lessonToUpdate);
    }

    public void deleteLesson(Integer id) {
        lessonRepository.deleteById(id);
    }

}
