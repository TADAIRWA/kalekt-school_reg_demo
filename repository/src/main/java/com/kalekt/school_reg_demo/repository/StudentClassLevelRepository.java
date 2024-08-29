package com.kalekt.school_reg_demo.repository;

import com.kalekt.school_reg_demo.model.StudentClassLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassLevelRepository extends JpaRepository<StudentClassLevel, Long> {
    Page<StudentClassLevel> findAllByStudent_IdAndDeletedIsFalse(Long id, Pageable pageable);

    Page<StudentClassLevel> findAllByClassLevel_IdAndDeletedIsFalse(Long id, Pageable pageable);

    Page<StudentClassLevel> findAllByStudent_StudentIDAndDeletedIsFalse(String studentID, Pageable pageable);
}
