package com.kalekt.school_reg_demo.repository;

import com.kalekt.school_reg_demo.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByIdAndDeletedIsFalse(Long id);

    Optional<Teacher> findByTeacherIDAndDeletedIsFalse(String teacherID);

    Page<Teacher> findAllByDeletedIsFalse(Pageable pageable);
}
