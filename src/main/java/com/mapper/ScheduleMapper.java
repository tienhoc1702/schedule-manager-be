package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.ScheduleDTO;
import com.entity.Schedule;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

	ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);  

	@Mapping(source = "clazz.code", target = "clazz_code")
	@Mapping(source = "clazz.subject.code", target = "subject_code")
	@Mapping(source = "clazz.subject.name", target = "subject_name")
	@Mapping(source = "clazz.instructor.code", target = "instructor_code")
	@Mapping(source = "clazz.shift.id", target = "shift_id")
	@Mapping(source = "clazz.shift.start_time", target = "start_time")
	@Mapping(source = "clazz.shift.end_time", target = "end_time")
	@Mapping(source = "clazz.room.room", target = "room_code")
    ScheduleDTO toDTO(Schedule schedule);  
    
//    //@Mapping(source = "clazz_id", target = "clazz.id")
//	@Mapping(source = "clazz_code", target = "clazz.code")
//	
//	//@Mapping(source = "subject_id", target = "clazz.subject.id")
//	@Mapping(source = "subject_code", target = "clazz.subject.code")
//	@Mapping(source = "subject_name", target = "clazz.subject.name")
//	
//	//@Mapping(source = "instructor_id", target = "clazz.instructor.id")
//	@Mapping(source = "instructor_code", target = "clazz.instructor.code")
//	
//	@Mapping(source = "block", target = "clazz.block.block")
//	//@Mapping(source = "semester", target = "clazz.semester.semester")
//	//@Mapping(source = "year", target = "clazz.year.year")
//	
//	@Mapping(source = "shift_id", target = "clazz.shift.id")
//	@Mapping(source = "start_time", target = "clazz.shift.start_time")
//	@Mapping(source = "end_time", target = "clazz.shift.end_time")
//	
//	//@Mapping(source = "room_id", target = "clazz.room.id")
//	@Mapping(source = "room_code", target = "clazz.room.room")
//	
//	//@Mapping(source = "weekday_id", target = "clazz.weekDay.id")
//	@Mapping(source = "start_date", target = "clazz.weekDay.start_time")
    Schedule toEntity(ScheduleDTO scheduleDTO);
}
