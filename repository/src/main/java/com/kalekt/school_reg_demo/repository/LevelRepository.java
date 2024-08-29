package com.kalekt.school_reg_demo.repository;

import com.kalekt.school_reg_demo.model.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    Optional<Level> findByIdAndDeletedIsFalse(Long id);

    Page<Level> findAllByDeletedIsFalse(Pageable pageable);
}
