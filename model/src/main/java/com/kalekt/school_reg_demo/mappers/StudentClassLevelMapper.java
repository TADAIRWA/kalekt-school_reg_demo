package com.kalekt.school_reg_demo.mappers;

import com.kalekt.school_reg_demo.dto.StudentClassLevelDTO;
import com.kalekt.school_reg_demo.model.StudentClassLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentClassLevelMapper {
    StudentClassLevelMapper INSTANCE = Mappers.getMapper(StudentClassLevelMapper.class);

    @Mapping(source = "studentBusinessId", target = "student.studentID")
    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "levelId", target = "classLevel.level.id")
    @Mapping(source = "levelName", target = "classLevel.level.name")
    @Mapping(source = "classId", target = "classLevel.aClass.id")
    @Mapping(source = "className", target = "classLevel.aClass.name")
    StudentClassLevel studentClassLevelDTOToStudentClassLevel(StudentClassLevelDTO studentClassLevelDTO);

    @Mapping(source = "student.studentID", target = "studentBusinessId")
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "classLevel.level.id", target = "levelId")
    @Mapping(source = "classLevel.level.name", target = "levelName")
    @Mapping(source = "classLevel.aClass.id", target = "classId")
    @Mapping(source = "classLevel.aClass.name", target = "className")
    StudentClassLevelDTO studentClassLevelToStudentClassLevelDTO(StudentClassLevel studentClassLevel);
}
