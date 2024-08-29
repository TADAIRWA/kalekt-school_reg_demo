package com.kalekt.school_reg_demo.dto;

import lombok.Data;

@Data
public class TeacherClassLevelDTO {
    private String teacherBusinessId;
    private Long teacherId;
    private Long classId;
    private String className;
    private Long levelId;
    private String levelName;
}
