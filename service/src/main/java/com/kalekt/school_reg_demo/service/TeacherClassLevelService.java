package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.TeacherClassLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherClassLevelService {
    TeacherClassLevel addTeacherToClass(Long teacherId, Long classId, Long levelId);

    Page<TeacherClassLevel> findAllByTeachersTeacherId(String teacherId, Pageable pageable);

    Page<TeacherClassLevel> findAllByTeacherId(Long teacherId, Pageable pageable);

    Page<TeacherClassLevel> findAllByClassLevelId(Long classLevelId, Pageable pageable);

}
