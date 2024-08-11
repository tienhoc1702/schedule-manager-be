package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import com.dto.ClazzDTO;
import com.entity.Clazz;

@Mapper(componentModel = "spring")
public interface ClazzMapper {

	ClazzMapper INSTANCE = Mappers.getMapper(ClazzMapper.class);  

	@Mapping(source = "block.block", target = "block_id")
    @Mapping(source = "semester.semester", target = "semester_id")
    @Mapping(source = "year.year", target = "year_id")
    @Mapping(source = "subject.name", target = "subject_name")
	@Mapping(source = "subject.code", target = "subject_code")
	@Mapping(source = "subject.credits", target = "subject_credit")
    @Mapping(source = "instructor.code", target = "instructor_code")
    @Mapping(source = "admin.code", target = "admin_name")
    @Mapping(source = "shift.id", target = "shift_id")
	@Mapping(source = "shift.start_time", target = "start_time")
	@Mapping(source = "shift.end_time", target = "end_time")
    @Mapping(source = "weekDay.id", target = "weekday_id")
    @Mapping(source = "room.room", target = "room_id")
	@Mapping(source = "schedules", target = "schedules")
	ClazzDTO toDTO(Clazz clazz);  
    	
	@Mapping(source = "block_id", target = "block.block")
    @Mapping(source = "semester_id", target = "semester.semester")
    @Mapping(source = "year_id", target = "year.year")
    @Mapping(source = "subject_name", target = "subject.name")
	@Mapping(source = "subject_code", target = "subject.code")
    @Mapping(source = "instructor_code", target = "instructor.code")
    @Mapping(source = "admin_name", target = "admin.name")
    @Mapping(source = "shift_id", target = "shift.id")
    @Mapping(source = "weekday_id", target = "weekDay.id")
    @Mapping(source = "room_id", target = "room.id")
	@Mapping(source = "schedules", target = "schedules")
	Clazz toEntity(ClazzDTO clazzDTO); 
	
	
	List<ClazzDTO> toDTOList(List<Clazz> clazzs);  
    
	List<Clazz> toEntityList(List<ClazzDTO> clazzDTOs);
}
