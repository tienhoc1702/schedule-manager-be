package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.TeachForDTO;
import com.entity.TeachFor;

@Mapper(componentModel = "spring")
public interface TeachForMapper {

	TeachForMapper INSTANCE = Mappers.getMapper(TeachForMapper.class);  

	@Mapping(source = "instructor.id", target = "instructor_id")
    @Mapping(source = "specialization.id", target = "specialization_id")
    TeachForDTO toDTO(TeachFor teachFor);  
    
    @Mapping(source = "instructor_id", target = "instructor.id")
    @Mapping(source = "specialization_id", target = "specialization.id")
    TeachFor toEntity(TeachForDTO teachForDTO);
}
