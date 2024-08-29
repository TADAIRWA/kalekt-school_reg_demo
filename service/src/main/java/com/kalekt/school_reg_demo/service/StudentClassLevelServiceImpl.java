package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.ClassLevel;
import com.kalekt.school_reg_demo.model.Student;
import com.kalekt.school_reg_demo.model.StudentClassLevel;
import com.kalekt.school_reg_demo.repository.StudentClassLevelRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class StudentClassLevelServiceImpl implements StudentClassLevelService {
    private StudentService studentService;
    private ClassService classService;
    private ClassLevelService classLevelService;
    private StudentClassLevelRepository studentClassLevelRepository;
    private LevelService levelService;

    @Override
    public StudentClassLevel addStudentToClass(Long studentId, Long classId, Long levelId) {
        Student student = studentService.findById(studentId);
        if (!(student.getLevel().getId().equals(levelId)))
            throw new IllegalArgumentException("Student cannot be added to class at a different level as student level!!!");
        ClassLevel classLevel = classLevelService.findByClassAndLevel(classId, levelId);
        return studentClassLevelRepository.save(new StudentClassLevel(classLevel, student));
    }

    @Override
    public Page<StudentClassLevel> findAllByStudentsStudentId(String studentId, Pageable pageable) {
        return studentClassLevelRepository.findAllByStudent_StudentIDAndDeletedIsFalse(studentId, pageable);
    }

    @Override
    public Page<StudentClassLevel> findAllByStudentId(Long studentId, Pageable pageable) {
        return studentClassLevelRepository.findAllByStudent_IdAndDeletedIsFalse(studentId, pageable);
    }

    @Override
    public Page<StudentClassLevel> findAllByClassLevelId(Long classLevelId, Pageable pageable) {
        return studentClassLevelRepository.findAllByClassLevel_IdAndDeletedIsFalse(classLevelId, pageable);
    }
}
