package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.InstructorDTO;
import com.entity.Instructor;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
	InstructorMapper INSTANCE = Mappers.getMapper(InstructorMapper.class);  

	@Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "teachFors", target = "teachFors")
    InstructorDTO toDTO(Instructor instructor);  
    
    @Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "teachFors", target = "teachFors")
    Instructor toEntity(InstructorDTO instructorDTO);
}
