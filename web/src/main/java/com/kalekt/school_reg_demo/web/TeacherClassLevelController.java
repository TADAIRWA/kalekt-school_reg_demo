package com.kalekt.school_reg_demo.web;

import com.kalekt.school_reg_demo.dto.TeacherClassLevelDTO;
import com.kalekt.school_reg_demo.mappers.TeacherClassLevelMapper;
import com.kalekt.school_reg_demo.service.TeacherClassLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher_class_level")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherClassLevelController {
    private TeacherClassLevelMapper teacherClassLevelMapper;
    private TeacherClassLevelService teacherClassLevelService;

    @PostMapping("/add/teacher/{teacherId}/class/{classId}/level/{levelId}")
    public ResponseEntity<TeacherClassLevelDTO> addTeacherToClass(@PathVariable("teacherId") Long teacherId, @PathVariable("classId") Long classId, @PathVariable("levelId") Long leveLId) {
        return new ResponseEntity<>(teacherClassLevelMapper.teacherClassLevelToTeacherClassLevelDTO(teacherClassLevelService.addTeacherToClass(teacherId, classId, leveLId)), HttpStatus.CREATED);
    }

    @GetMapping("/teacher_business_id/{teacherId}")
    public ResponseEntity<Page<TeacherClassLevelDTO>> findByTeacherBusinessId(@PathVariable("teacherId") String teacherId, Pageable pageable) {
        return new ResponseEntity<>(teacherClassLevelService.findAllByTeachersTeacherId(teacherId, pageable).map(teacherClassLevelMapper::teacherClassLevelToTeacherClassLevelDTO), HttpStatus.OK);
    }

    @GetMapping("/teacher_id/{teacherId}")
    public ResponseEntity<Page<TeacherClassLevelDTO>> findByTeacherId(@PathVariable("teacherId") Long teacherId, Pageable pageable) {
        return new ResponseEntity<>(teacherClassLevelService.findAllByTeacherId(teacherId, pageable).map(teacherClassLevelMapper::teacherClassLevelToTeacherClassLevelDTO), HttpStatus.OK);
    }

    @GetMapping("/class_level_id/{classLevelId}")
    public ResponseEntity<Page<TeacherClassLevelDTO>> findByTeacherBusinessId(@PathVariable("classLevelId") Long classLevelId, Pageable pageable) {
        return new ResponseEntity<>(teacherClassLevelService.findAllByClassLevelId(classLevelId, pageable).map(teacherClassLevelMapper::teacherClassLevelToTeacherClassLevelDTO), HttpStatus.OK);
    }

}
