package com.kalekt.school_reg_demo.mappers;

import com.kalekt.school_reg_demo.dto.LevelDTO;
import com.kalekt.school_reg_demo.model.Level;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LevelMapper {
    LevelMapper INSTANCE = Mappers.getMapper(LevelMapper.class);


    Level levelDTOToLevel(LevelDTO levelDTO);

    LevelDTO levelToLevelDTO(Level level);
}
