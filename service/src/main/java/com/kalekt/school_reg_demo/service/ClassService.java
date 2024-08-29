package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClassService {
    Class findById(Long id);

    Page<Class> findAll(Pageable pageable);

    Class save(Class aClass);
}
