package com.kalekt.school_reg_demo.web;

import com.kalekt.school_reg_demo.dto.StudentDTO;
import com.kalekt.school_reg_demo.mappers.StudentMapper;
import com.kalekt.school_reg_demo.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
    private StudentService studentService;
    private StudentMapper studentMapper;

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentMapper.studentToStudentDTO(studentService.save(studentMapper.studentDTOToStudent(studentDTO))), HttpStatus.CREATED);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<StudentDTO> update(@PathVariable("studentId") Long studentId, @Valid @RequestBody StudentDTO updatedStudentDTO) {
        return new ResponseEntity<>(studentMapper.studentToStudentDTO(studentService.updateStudent(studentId, studentMapper.studentDTOToStudent(updatedStudentDTO))), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<StudentDTO> delete(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentMapper.studentToStudentDTO(studentService.deleteStudent(studentId)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/student_business_id/{studentBusinessId}")
    public ResponseEntity<StudentDTO> findByStudentBusinessId(@PathVariable("studentBusinessId") String studentBusinessId) {
        return new ResponseEntity<>(studentMapper.studentToStudentDTO(studentService.findByStudentId(studentBusinessId)), HttpStatus.OK);
    }

    @GetMapping("/student_id/{studentId}")
    public ResponseEntity<StudentDTO> findByStudentId(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentMapper.studentToStudentDTO(studentService.findById(studentId)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> getAll(Pageable pageable) {
        return new ResponseEntity<>(studentService.findAll(pageable).map(studentMapper::studentToStudentDTO), HttpStatus.OK);
    }
}
