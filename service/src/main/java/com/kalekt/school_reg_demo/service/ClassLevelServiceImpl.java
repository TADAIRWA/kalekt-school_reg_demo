package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Class;
import com.kalekt.school_reg_demo.model.ClassLevel;
import com.kalekt.school_reg_demo.model.Level;
import com.kalekt.school_reg_demo.repository.ClassLevelRepository;
import com.kalekt.school_reg_demo.utilities.exceptions.RecordNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class ClassLevelServiceImpl implements ClassLevelService {
    private ClassLevelRepository classLevelRepository;
    private ClassService classService;
    private LevelService levelService;

    @Override
    public ClassLevel findByClassAndLevel(Long classID, Long levelID) {
        Class aClass = classService.findById(classID);
        Level level = levelService.findById(levelID);
        return classLevelRepository.findByAClassAndLevelAndDeletedIsFalse(aClass, level).orElseThrow(() ->
                new RecordNotFoundException("Class and Level combination not found"));
    }

    @Override
    public Page<ClassLevel> findAll(Pageable pageable) {
        return classLevelRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public ClassLevel save(Long classID, Long levelID) {
        Class aClass = classService.findById(classID);
        Level level = levelService.findById(levelID);
        return classLevelRepository.save(new ClassLevel(aClass, level));
    }
}
