package com.kalekt.school_reg_demo.mappers;

import com.kalekt.school_reg_demo.dto.ClassLevelDTO;
import com.kalekt.school_reg_demo.model.ClassLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassLevelMapper {
    ClassLevelMapper INSTANCE = Mappers.getMapper(ClassLevelMapper.class);

    @Mapping(source = "classID", target = "aClass.id")
    @Mapping(source = "className", target = "aClass.name")
    @Mapping(source = "levelName", target = "level.name")
    @Mapping(source = "levelID", target = "level.id")
    ClassLevel classLevelDTOToClassLevel(ClassLevelDTO classLevelDTO);

    @Mapping(source = "aClass.id", target = "classID")
    @Mapping(source = "aClass.name", target = "className")
    @Mapping(source = "level.name", target = "levelName")
    @Mapping(source = "level.id", target = "levelID")
    ClassLevelDTO classLevelToClassLevelDTO(ClassLevel classLevel);
}
