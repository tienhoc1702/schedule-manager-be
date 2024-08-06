package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.SubjectDTO;
import com.entity.Subject;


@Mapper(componentModel = "spring")
public interface SubjectMapper {

	SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);  

	@Mapping(source = "required", target = "required")
    SubjectDTO toDTO(Subject subject);  

//    @Mapping(source = "apply_fors", target = "applyFors")
//    @Mapping(source = "clazzs", target = "clazzs")
//    @Mapping(source = "study_histories", target = "studyHistories")
//    @Mapping(source = "belongs", target = "belongs")
//    @Mapping(source = "registers", target = "registers")
    @Mapping(source = "required", target = "required")
    @Mapping(target = "requiredSubjects", ignore = true)
    Subject toEntity(SubjectDTO subjectDTO);  

    List<SubjectDTO> toDTOList(List<Subject> subjects);

    List<Subject> toEntityList(List<SubjectDTO> subjectDTOs); 
}
