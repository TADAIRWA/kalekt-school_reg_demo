package com.kalekt.school_reg_demo.mappers;

import com.kalekt.school_reg_demo.dto.StudentDTO;
import com.kalekt.school_reg_demo.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "levelID", target = "level.id")
    @Mapping(source = "levelName", target = "level.name")
    Student studentDTOToStudent(StudentDTO studentDTO);

    @Mapping(source = "level.id", target = "levelID")
    @Mapping(source = "level.name", target = "levelName")
    StudentDTO studentToStudentDTO(Student student);
}
