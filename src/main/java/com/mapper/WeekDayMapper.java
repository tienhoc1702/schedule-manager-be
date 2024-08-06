package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import com.dto.WeekDayDTO;
import com.entity.WeekDay;

@Mapper(componentModel = "spring")
public interface WeekDayMapper {
	WeekDayMapper INSTANCE = Mappers.getMapper(WeekDayMapper.class); 
	
	@Mapping(source = "clazzs", target = "clazzs")
    WeekDayDTO toDTO(WeekDay weekDay);  
    
	@Mapping(source = "clazzs", target = "clazzs")
    WeekDay toEntity(WeekDayDTO teachForDTO);
}
