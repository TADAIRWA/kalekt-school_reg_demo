package com.kalekt.school_reg_demo.repository;

import com.kalekt.school_reg_demo.model.Class;
import com.kalekt.school_reg_demo.model.ClassLevel;
import com.kalekt.school_reg_demo.model.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassLevelRepository extends JpaRepository<ClassLevel, Long> {
    Optional<ClassLevel> findByAClassAndLevelAndDeletedIsFalse(Class aClass, Level level);

    Page<ClassLevel> findAllByDeletedIsFalse(Pageable pageable);
}
