package com.kalekt.school_reg_demo.dto;

import lombok.Data;

@Data
public class StudentClassLevelDTO {
    private String studentBusinessId;
    private Long studentId;
    private Long classId;
    private String className;
    private Long levelId;
    private String levelName;
}
