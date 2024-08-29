package com.kalekt.school_reg_demo.web;

import com.kalekt.school_reg_demo.dto.ClassLevelDTO;
import com.kalekt.school_reg_demo.mappers.ClassLevelMapper;
import com.kalekt.school_reg_demo.service.ClassLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/class_level")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClassLevelController {
    private ClassLevelService classLevelService;
    private ClassLevelMapper classLevelMapper;

    @PostMapping("/create/level/{levelId}/class/{classId}")
    public ResponseEntity<ClassLevelDTO> create(@PathVariable("levelId") long levelId, @PathVariable("classId") long classId) {
        return new ResponseEntity<>(classLevelMapper.classLevelToClassLevelDTO(classLevelService.save(classId, levelId)), HttpStatus.CREATED);
    }

    @GetMapping("/level/{levelId}/class/{classId}")
    public ResponseEntity<ClassLevelDTO> findByLevelAndClass(@PathVariable("levelId") long levelId, @PathVariable("classId") long classId) {
        return new ResponseEntity<>(classLevelMapper.classLevelToClassLevelDTO(classLevelService.findByClassAndLevel(classId, levelId)), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<Page<ClassLevelDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(classLevelService.findAll(pageable).map(classLevelMapper::classLevelToClassLevelDTO), HttpStatus.OK);
    }
}
