package com.kalekt.school_reg_demo.repository;


import com.kalekt.school_reg_demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    Optional<Student> findByStudentIDAndDeletedIsFalse(String studentID);

    Page<Student> findAllByDeletedIsFalse(Pageable pageable);
}
