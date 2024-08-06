package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.MarkDTO;
import com.entity.Mark;

@Mapper(componentModel = "spring")
public interface MarkMapper {

	MarkMapper INSTANCE = Mappers.getMapper(MarkMapper.class);  

	@Mapping(source = "studyHistory.id", target = "study_history")
    MarkDTO toDTO(Mark mark);

    @Mapping(source = "study_history", target = "studyHistory.id")
    Mark toEntity(MarkDTO markDTO); 
}
