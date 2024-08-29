package com.kalekt.school_reg_demo.repository;

import com.kalekt.school_reg_demo.model.TeacherClassLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherClassLevelRepository extends JpaRepository<TeacherClassLevel, Long> {
    Page<TeacherClassLevel> findAllByTeacher_IdAndDeletedIsFalse(Long id, Pageable pageable);

    Page<TeacherClassLevel> findAllByTeacher_TeacherIDAndDeletedIsFalse(String teacherId, Pageable pageable);

    Page<TeacherClassLevel> findAllByClassLevel_IdAAndDeletedIsFalse(Long classLevelId, Pageable pageable);
}
