package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Teacher;
import com.kalekt.school_reg_demo.repository.TeacherRepository;
import com.kalekt.school_reg_demo.service.config.SystemProperties;
import com.kalekt.school_reg_demo.utilities.exceptions.RecordNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@Data
@RequiredArgsConstructor
public class TeacherServiceImpl {
    private TeacherRepository teacherRepository;
    private SystemProperties systemProperties;

    public Teacher save(Teacher teacher) {
        Teacher initiallySavedTeacher = teacherRepository.save(teacher);
        if (Objects.isNull(initiallySavedTeacher.getTeacherID())) {
            initiallySavedTeacher.setTeacherID(generateTeacherId(initiallySavedTeacher));
        }
        return teacherRepository.save(initiallySavedTeacher);
    }

    private String generateTeacherId(Teacher initiallySavedTeacher) {
        Long generatedID = initiallySavedTeacher.getId();
        LocalDate currentDate = LocalDate.now();
        String year = String.valueOf(currentDate.getYear());
        String month = currentDate.format(DateTimeFormatter.ofPattern("MM"));
        return systemProperties.getTeacherIDPrefix() + year + month + generatedID;
    }

    public Teacher findById(Long id) {
        return teacherRepository.findByIdAndDeletedIsFalse(id).orElseThrow(
                () -> new RecordNotFoundException("Teacher with id {0} not found", id)
        );
    }

    public Teacher findByTeacherId(String id) {
        return teacherRepository.findByTeacherIDAndDeletedIsFalse(id).orElseThrow(
                () -> new RecordNotFoundException("Teacher with id {0} not found", id)
        );
    }

    Page<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAllByDeletedIsFalse(pageable);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        return teacherRepository.findByIdAndDeletedIsFalse(id)
                .map(existingTeacher -> {
                    existingTeacher.setActive(updatedTeacher.isActive());
                    existingTeacher.setDateOfBirth(updatedTeacher.getDateOfBirth());
                    existingTeacher.setFirstName(updatedTeacher.getFirstName());
                    existingTeacher.setLastName(updatedTeacher.getLastName());
                    existingTeacher.setGender(updatedTeacher.getGender());
                    return teacherRepository.save(existingTeacher);
                }).orElseThrow(() -> new RecordNotFoundException("Teacher with id {0} not found", id));
    }

    public Teacher deleteTeacher(Long id) {
        Teacher teacher = findById(id);
        teacher.setDeleted(true);
        return teacherRepository.save(teacher);
    }
}
