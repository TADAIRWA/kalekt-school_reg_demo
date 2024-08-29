package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Class;
import com.kalekt.school_reg_demo.repository.ClassRepository;
import com.kalekt.school_reg_demo.utilities.exceptions.RecordNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;


    @Override
    public Class findById(Long id) {
        return classRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new RecordNotFoundException("Class with id {0} not found", id));
    }

    @Override
    public Page<Class> findAll(Pageable pageable) {
        return classRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Class save(Class aClass) {
        return classRepository.save(aClass);
    }
}
