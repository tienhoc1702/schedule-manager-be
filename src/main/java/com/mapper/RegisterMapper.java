package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.RegisterDTO;
import com.entity.Register;

@Mapper(componentModel = "spring")
public interface RegisterMapper {

	RegisterMapper INSTANCE = Mappers.getMapper(RegisterMapper.class);  


    @Mapping(source = "subject.id", target = "subject_id")
    @Mapping(source = "student.id", target = "student_id")
    @Mapping(source = "clazz.id", target = "clazz_id")
    RegisterDTO toDTO(Register register);  
    
    @Mapping(source = "subject_id", target = "subject.id")
    @Mapping(source = "student_id", target = "student.id")
    @Mapping(source = "clazz_id", target = "clazz.id")
    Register toEntity(RegisterDTO registerDTO); 
}
