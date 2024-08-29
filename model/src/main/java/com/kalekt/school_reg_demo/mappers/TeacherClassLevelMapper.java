package com.kalekt.school_reg_demo.mappers;

import com.kalekt.school_reg_demo.dto.TeacherClassLevelDTO;
import com.kalekt.school_reg_demo.model.TeacherClassLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherClassLevelMapper {
    TeacherClassLevelMapper INSTANCE = Mappers.getMapper(TeacherClassLevelMapper.class);

    @Mapping(source = "teacherBusinessId", target = "teacher.teacherID")
    @Mapping(source = "teacherId", target = "teacher.id")
    @Mapping(source = "levelId", target = "classLevel.level.id")
    @Mapping(source = "levelName", target = "classLevel.level.name")
    @Mapping(source = "classId", target = "classLevel.aClass.id")
    @Mapping(source = "className", target = "classLevel.aClass.name")
    TeacherClassLevel teacherClassLevelDTOToTeacherClassLevel(TeacherClassLevelDTO teacherClassLevelDTO);

    @Mapping(source = "teacher.teacherID", target = "teacherBusinessId")
    @Mapping(source = "teacher.id", target = "teacherId")
    @Mapping(source = "classLevel.level.id", target = "levelId")
    @Mapping(source = "classLevel.level.name", target = "levelName")
    @Mapping(source = "classLevel.aClass.id", target = "classId")
    @Mapping(source = "classLevel.aClass.name", target = "className")
    TeacherClassLevelDTO teacherClassLevelToTeacherClassLevelDTO(TeacherClassLevel teacherClassLevel);
}
