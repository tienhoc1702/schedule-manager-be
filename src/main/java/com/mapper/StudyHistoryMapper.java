package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.dto.StudyHistoryDTO;
import com.entity.StudyHistory;

@Mapper(uses = MarkMapper.class)
public interface StudyHistoryMapper {

	StudyHistoryMapper INSTANCE = Mappers.getMapper(StudyHistoryMapper.class);  

	@Mapping(source = "block.block", target = "block_id")
    @Mapping(source = "semester.semester", target = "semester_id")
    @Mapping(source = "year.year", target = "year_id")
    @Mapping(source = "student.id", target = "student_id")
    @Mapping(source = "subject.id", target = "subject_id")
    @Mapping(source = "marks", target = "marks")
    StudyHistoryDTO toDTO(StudyHistory studyhistory);  
    
    @Mapping(source = "block_id", target = "block.block")
    @Mapping(source = "semester_id", target = "semester.semester")
    @Mapping(source = "year_id", target = "year.year")
    @Mapping(source = "student_id", target = "student.id")
    @Mapping(source = "subject_id", target = "subject.id")
    @Mapping(source = "marks", target = "marks")
    StudyHistory toEntity(StudyHistoryDTO studyhistoryDTO);  

    List<StudyHistoryDTO> toDTOList(List<StudyHistory> studyhistories);  
    
    List<StudyHistory> toEntityList(List<StudyHistoryDTO> studyhistoryDTOs);
}
