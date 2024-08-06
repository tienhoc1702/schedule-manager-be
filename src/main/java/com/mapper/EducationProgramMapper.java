package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.EducationProgramDTO;
import com.entity.EducationProgram;

@Mapper(componentModel = "spring")
public interface EducationProgramMapper {

	EducationProgramMapper INSTANCE = Mappers.getMapper(EducationProgramMapper.class);  

	@Mapping(source = "major.id", target = "major_id")
    @Mapping(source = "year.year", target = "year_id")
    EducationProgramDTO toDTO(EducationProgram educationprogram);

    @Mapping(source = "major_id", target = "major.id")
    @Mapping(source = "year_id", target = "year.year")
    EducationProgram toEntity(EducationProgramDTO educationprogramDTO);
}
	
