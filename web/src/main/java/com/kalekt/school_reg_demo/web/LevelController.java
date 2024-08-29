package com.kalekt.school_reg_demo.web;

import com.kalekt.school_reg_demo.dto.LevelDTO;
import com.kalekt.school_reg_demo.mappers.LevelMapper;
import com.kalekt.school_reg_demo.service.LevelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/level")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LevelController {
    private LevelService levelService;
    private LevelMapper levelMapper;

    @PostMapping("/create")
    public ResponseEntity<LevelDTO> create(@Valid @RequestBody LevelDTO levelDTO) {
        return new ResponseEntity<>(levelMapper.levelToLevelDTO(levelService.save(levelMapper.levelDTOToLevel(levelDTO))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<LevelDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(levelService.findAll(pageable).map(levelMapper::levelToLevelDTO), HttpStatus.OK);
    }
}
