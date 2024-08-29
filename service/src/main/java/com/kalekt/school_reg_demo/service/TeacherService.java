package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Teacher save(Teacher teacher);

    Page<Teacher> findAll(Pageable pageable);

    Teacher findById(Long id);

    Teacher findByTeacherId(String teacherId);

    Teacher updateTeacher(Long id, Teacher updatedTeacher);

    Teacher deleteTeacher(Long id);
}
