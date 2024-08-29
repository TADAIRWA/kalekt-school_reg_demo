package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Student save(Student student);

    Page<Student> findAll(Pageable pageable);

    Student findById(Long id);

    Student findByStudentId(String studentId);

    Student updateStudent(Long id, Student updatedStudent);

    Student deleteStudent(Long id);
}
