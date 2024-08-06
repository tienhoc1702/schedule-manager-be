package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.School_YearDTO;
import com.entity.School_Year;

@Mapper(componentModel = "spring")
public interface School_YearMapper {

	School_YearMapper INSTANCE = Mappers.getMapper(School_YearMapper.class);  

	
    @Mapping(source = "education_programs", target = "education_programs")
    @Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "students", target = "students")
    @Mapping(source = "studyHistories", target = "studyHistories")
	School_YearDTO toDTO(School_Year school_Year);  
    
	
    @Mapping(source = "education_programs", target = "education_programs")
    @Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "students", target = "students")
    @Mapping(source = "studyHistories", target = "studyHistories")
	School_Year toEntity(School_YearDTO school_YearDTO);  
}
