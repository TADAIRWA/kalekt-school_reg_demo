package com.kalekt.school_reg_demo.web;

import com.kalekt.school_reg_demo.dto.TeacherDTO;
import com.kalekt.school_reg_demo.mappers.TeacherMapper;
import com.kalekt.school_reg_demo.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherController {
    private TeacherService teacherService;
    private TeacherMapper teacherMapper;

    @PostMapping("/create")
    public ResponseEntity<TeacherDTO> create(@Valid @RequestBody TeacherDTO teacherDTO) {
        return new ResponseEntity<>(teacherMapper.teacherToTeacherDTO(teacherService.save(teacherMapper.teacherDTOToTeacher(teacherDTO))), HttpStatus.CREATED);
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity<TeacherDTO> update(@PathVariable("teacherId") Long teacherId, @Valid @RequestBody TeacherDTO updatedTeacherDTO) {
        return new ResponseEntity<>(teacherMapper.teacherToTeacherDTO(teacherService.updateTeacher(teacherId, teacherMapper.teacherDTOToTeacher(updatedTeacherDTO))), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<TeacherDTO> delete(@PathVariable("teacherId") Long teacherId) {
        return new ResponseEntity<>(teacherMapper.teacherToTeacherDTO(teacherService.deleteTeacher(teacherId)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/teacher_business_id/{teacherBusinessId}")
    public ResponseEntity<TeacherDTO> findByTeacherBusinessId(@PathVariable("teacherBusinessId") String teacherBusinessId) {
        return new ResponseEntity<>(teacherMapper.teacherToTeacherDTO(teacherService.findByTeacherId(teacherBusinessId)), HttpStatus.OK);
    }

    @GetMapping("/teacher_id/{teacherId}")
    public ResponseEntity<TeacherDTO> findByTeacherId(@PathVariable("teacherId") Long teacherId) {
        return new ResponseEntity<>(teacherMapper.teacherToTeacherDTO(teacherService.findById(teacherId)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<TeacherDTO>> getAll(Pageable pageable) {
        return new ResponseEntity<>(teacherService.findAll(pageable).map(teacherMapper::teacherToTeacherDTO), HttpStatus.OK);
    }
}
