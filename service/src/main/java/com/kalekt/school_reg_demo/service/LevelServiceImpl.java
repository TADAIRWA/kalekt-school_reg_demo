package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.Level;
import com.kalekt.school_reg_demo.repository.LevelRepository;
import com.kalekt.school_reg_demo.utilities.exceptions.RecordNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    private LevelRepository levelRepository;

    @Override
    public Level findById(Long id) {
        return levelRepository.findByIdAndDeletedIsFalse(id).orElseThrow((() -> new RecordNotFoundException("Level with id {0} not found", id)));
    }

    @Override
    public Page<Level> findAll(Pageable pageable) {
        return levelRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }
}
