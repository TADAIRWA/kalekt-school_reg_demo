package com.kalekt.school_reg_demo.mappers;

import com.kalekt.school_reg_demo.dto.ClassDTO;
import com.kalekt.school_reg_demo.model.Class;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassMapper {
    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    Class classDTOToClass(ClassDTO classDTO);

    ClassDTO classToClassDTO(Class aClass);
}
