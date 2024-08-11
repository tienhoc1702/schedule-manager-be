package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.dto.StudyInDTO;
import com.entity.StudyIn;

@Mapper(componentModel = "spring")
public interface StudyInMapper {
	
	StudyInMapper INSTANCE = Mappers.getMapper(StudyInMapper.class);  	
	@Mapping(source = "id", target = "studyin_id")
	@Mapping(source = "clazz.id", target = "clazz_id")
    @Mapping(source = "student.id", target = "student_id")
	@Mapping(source = "student.code", target = "student_code")
	@Mapping(source = "clazz.subject.id", target = "subject_id")
	@Mapping(source = "clazz.subject.name", target = "subject_name")
	@Mapping(source = "clazz.subject.code", target = "subject_code")
	@Mapping(source = "clazz.subject.credits", target = "subject_credit")
	@Mapping(source = "clazz.block.block", target = "block")
	@Mapping(source = "clazz.semester.semester", target = "semester_id")
	@Mapping(source = "clazz.year.year", target = "year")
	@Mapping(source = "clazz.instructor.code", target = "instructor_code")
	@Mapping(source = "clazz.shift.id", target = "shift_id")
	@Mapping(source = "clazz.shift.start_time", target = "start_time")
	@Mapping(source = "clazz.shift.end_time", target = "end_time")
	@Mapping(source = "clazz.weekDay.start_time", target = "weekday_date")
	@Mapping(source = "clazz.room.room", target = "room")
    StudyInDTO toDTO(StudyIn studyin);  
	
    
	@Mapping(source = "studyin_id", target = "id")
    @Mapping(source = "clazz_id", target = "clazz.id")
    @Mapping(source = "student_id", target = "student.id")
    StudyIn toEntity(StudyInDTO studyinDTO);  

    List<StudyInDTO> toDTOList(List<StudyIn> studyins);  
    
    List<StudyIn> toEntityList(List<StudyInDTO> StudyInDTOs); 
}
