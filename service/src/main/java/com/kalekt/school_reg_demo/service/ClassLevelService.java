package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.ClassLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClassLevelService {
    ClassLevel findByClassAndLevel(Long classID, Long levelID);

    Page<ClassLevel> findAll(Pageable pageable);

    ClassLevel save(Long classID, Long levelID);
}
