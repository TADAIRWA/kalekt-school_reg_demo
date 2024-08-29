package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.StudentClassLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentClassLevelService {
    StudentClassLevel addStudentToClass(Long studentId, Long classId, Long levelId);

    Page<StudentClassLevel> findAllByStudentsStudentId(String studentId, Pageable pageable);

    Page<StudentClassLevel> findAllByStudentId(Long studentId, Pageable pageable);

    Page<StudentClassLevel> findAllByClassLevelId(Long classLevelId, Pageable pageable);
}
