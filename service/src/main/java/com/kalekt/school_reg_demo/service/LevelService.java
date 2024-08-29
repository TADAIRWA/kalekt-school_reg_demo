package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LevelService {
    Level findById(Long id);

    Page<Level> findAll(Pageable pageable);

    Level save(Level level);
}
