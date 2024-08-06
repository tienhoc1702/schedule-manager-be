package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.ApplyForDTO;
import com.entity.ApplyFor;

@Mapper(componentModel = "spring")
public interface ApplyForMapper {

	ApplyForMapper INSTANCE = Mappers.getMapper(ApplyForMapper.class);  

	@Mapping(source = "subject.id", target = "subject_id")
    @Mapping(source = "education.id", target = "education_id")
    @Mapping(source = "study_semester", target = "study_semester", numberFormat = "#") // Chuyển đổi Integer thành String
    @Mapping(source = "study_block", target = "study_block")
    ApplyForDTO toDTO(ApplyFor applyfor);  
    
    @Mapping(source = "subject_id", target = "subject.id")
    @Mapping(source = "education_id", target = "education.id")
    @Mapping(source = "study_semester", target = "study_semester", numberFormat = "#") // Chuyển đổi String thành Integer
    @Mapping(source = "study_block", target = "study_block")
    ApplyFor toEntity(ApplyForDTO applyforDTO);

	List<ApplyForDTO> toDTO(List<ApplyFor> apply);
}
