package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.SemesterDTO;
import com.entity.Semester;

@Mapper(componentModel = "spring")
public interface SemesterMapper {

	SemesterMapper INSTANCE = Mappers.getMapper(SemesterMapper.class);  

    @Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "students", target = "students")
    @Mapping(source = "studyHistories", target = "studyHistories")
	SemesterDTO toDTO(Semester semester);  
    
    @Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "students", target = "students")
	Semester toEntity(SemesterDTO semesterDTO);  
}
