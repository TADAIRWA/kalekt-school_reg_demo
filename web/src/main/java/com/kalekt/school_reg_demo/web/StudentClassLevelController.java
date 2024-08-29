package com.kalekt.school_reg_demo.web;

import com.kalekt.school_reg_demo.dto.StudentClassLevelDTO;
import com.kalekt.school_reg_demo.mappers.StudentClassLevelMapper;
import com.kalekt.school_reg_demo.service.StudentClassLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student_class_level")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentClassLevelController {
    private StudentClassLevelMapper studentClassLevelMapper;
    private StudentClassLevelService studentClassLevelService;

    @PostMapping("/add/student/{studentId}/class/{classId}/level/{levelId}")
    public ResponseEntity<StudentClassLevelDTO> addStudentToClass(@PathVariable("studentId") Long studentId, @PathVariable("classId") Long classId, @PathVariable("levelId") Long leveLId) {
        return new ResponseEntity<>(studentClassLevelMapper.studentClassLevelToStudentClassLevelDTO(studentClassLevelService.addStudentToClass(studentId, classId, leveLId)), HttpStatus.CREATED);
    }

    @GetMapping("/student_business_id/{studentId}")
    public ResponseEntity<Page<StudentClassLevelDTO>> findByStudentBusinessId(@PathVariable("studentId") String studentId, Pageable pageable) {
        return new ResponseEntity<>(studentClassLevelService.findAllByStudentsStudentId(studentId, pageable).map(studentClassLevelMapper::studentClassLevelToStudentClassLevelDTO), HttpStatus.OK);
    }

    @GetMapping("/student_id/{studentId}")
    public ResponseEntity<Page<StudentClassLevelDTO>> findByStudentId(@PathVariable("studentId") Long studentId, Pageable pageable) {
        return new ResponseEntity<>(studentClassLevelService.findAllByStudentId(studentId, pageable).map(studentClassLevelMapper::studentClassLevelToStudentClassLevelDTO), HttpStatus.OK);
    }

    @GetMapping("/class_level_id/{classLevelId}")
    public ResponseEntity<Page<StudentClassLevelDTO>> findByStudentBusinessId(@PathVariable("classLevelId") Long classLevelId, Pageable pageable) {
        return new ResponseEntity<>(studentClassLevelService.findAllByClassLevelId(classLevelId, pageable).map(studentClassLevelMapper::studentClassLevelToStudentClassLevelDTO), HttpStatus.OK);
    }

}
