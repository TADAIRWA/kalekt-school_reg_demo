package com.kalekt.school_reg_demo.mappers;

import com.kalekt.school_reg_demo.dto.TeacherDTO;
import com.kalekt.school_reg_demo.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher teacherDTOToTeacher(TeacherDTO teacherDTO);

    TeacherDTO teacherToTeacherDTO(Teacher teacher);
}
