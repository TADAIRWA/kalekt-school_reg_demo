package com.kalekt.school_reg_demo.service;

import com.kalekt.school_reg_demo.model.ClassLevel;
import com.kalekt.school_reg_demo.model.Teacher;
import com.kalekt.school_reg_demo.model.TeacherClassLevel;
import com.kalekt.school_reg_demo.repository.TeacherClassLevelRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class TeacherClassLevelServiceImpl implements TeacherClassLevelService {
    private ClassService classService;
    private ClassLevelService classLevelService;
    private TeacherClassLevelRepository teacherClassLevelRepository;
    private TeacherService teacherService;

    @Override
    public TeacherClassLevel addTeacherToClass(Long teacherId, Long classId, Long levelId) {
        Teacher teacher = teacherService.findById(teacherId);
        ClassLevel classLevel = classLevelService.findByClassAndLevel(classId, levelId);
        return teacherClassLevelRepository.save(new TeacherClassLevel(classLevel, teacher));
    }

    @Override
    public Page<TeacherClassLevel> findAllByTeachersTeacherId(String teacherId, Pageable pageable) {
        return teacherClassLevelRepository.findAllByTeacher_TeacherIDAndDeletedIsFalse(teacherId, pageable);
    }

    @Override
    public Page<TeacherClassLevel> findAllByTeacherId(Long teacherId, Pageable pageable) {
        return teacherClassLevelRepository.findAllByTeacher_IdAndDeletedIsFalse(teacherId, pageable);
    }

    @Override
    public Page<TeacherClassLevel> findAllByClassLevelId(Long classLevelId, Pageable pageable) {
        return teacherClassLevelRepository.findAllByClassLevel_IdAAndDeletedIsFalse(classLevelId, pageable);
    }
}
