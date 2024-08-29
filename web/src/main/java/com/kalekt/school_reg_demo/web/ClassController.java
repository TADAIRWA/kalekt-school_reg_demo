package com.kalekt.school_reg_demo.web;

import com.kalekt.school_reg_demo.dto.ClassDTO;
import com.kalekt.school_reg_demo.mappers.ClassMapper;
import com.kalekt.school_reg_demo.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/class")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClassController {
    private ClassService classService;
    private ClassMapper classMapper;

    @PostMapping("/create")
    public ResponseEntity<ClassDTO> create(@RequestBody ClassDTO classDTO) {
        return new ResponseEntity<>(classMapper.classToClassDTO(classService.save(classMapper.classDTOToClass(classDTO))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ClassDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(classService.findAll(pageable).map(classMapper::classToClassDTO), HttpStatus.OK);
    }
}
