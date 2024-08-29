package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Student;
import com.kalekt.school_reg_demo.repository.StudentRepository;
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
public class StudentServiceImpl implements StudentService {
    private SystemProperties systemProperties;
    private StudentRepository studentRepository;

    public Student save(Student student) {
        Student initiallySavedStudent = studentRepository.save(student);
        if (Objects.isNull(initiallySavedStudent.getStudentID())) {
            initiallySavedStudent.setStudentID(generateStudentID(initiallySavedStudent));
        }
        return studentRepository.save(initiallySavedStudent);
    }

    private String generateStudentID(Student student) {
        Long generatedID = student.getId();
        LocalDate currentDate = LocalDate.now();
        String year = String.valueOf(currentDate.getYear());
        String month = currentDate.format(DateTimeFormatter.ofPattern("MM"));
        String id = systemProperties.getStudentIDPrefix() + year + month + generatedID;
        return id;
    }

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAllByDeletedIsFalse(pageable);
    }

    public Student findById(Long id) {
        return studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new RecordNotFoundException("Student with Id {0} not found! ", id));
    }

    @Override
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudentIDAndDeletedIsFalse(studentId)
                .orElseThrow(() -> new RecordNotFoundException("Student with Id {0} not found! ", studentId));
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findByIdAndDeletedIsFalse(id)
                .map(existingStudent -> {
                    existingStudent.setActive(updatedStudent.isActive());
                    existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
                    existingStudent.setFirstName(updatedStudent.getFirstName());
                    existingStudent.setLastName(updatedStudent.getLastName());
                    existingStudent.setGender(updatedStudent.getGender());
                    return studentRepository.save(existingStudent);
                }).orElseThrow(() -> new RecordNotFoundException("Student with Id {0} not found! ", id));
    }

    public Student deleteStudent(Long id) {
        Student student = findById(id);
        student.setDeleted(true);
        return studentRepository.save(student);
    }
}
