package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.MajorDTO;
import com.entity.Major;

@Mapper(componentModel = "spring")
public interface MajorMapper {

	MajorMapper INSTANCE = Mappers.getMapper(MajorMapper.class);  

	@Mapping(source = "specialization.id", target = "specialization")
    @Mapping(target = "educations", source = "educations")
    @Mapping(target = "students", source = "students")
    MajorDTO toDTO(Major major);  
    
    @Mapping(source = "specialization", target = "specialization.id")
    @Mapping(target = "educations", source = "educations")
    @Mapping(target = "students", source = "students")
    Major toEntity(MajorDTO majorDTO); 	
}
