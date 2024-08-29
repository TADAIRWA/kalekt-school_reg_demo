package com.kalekt.school_reg_demo.repository;

import com.kalekt.school_reg_demo.model.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findByIdAndDeletedIsFalse(Long id);

    Page<Class> findAllByDeletedIsFalse(Pageable pageable);
}
