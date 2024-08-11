package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.ShiftDTO;
import com.entity.Shift;

@Mapper(componentModel = "spring")
public interface ShiftMapper {

	ShiftMapper INSTANCE = Mappers.getMapper(ShiftMapper.class);  
	@Mapping (source = "id", target = "shift_id")	
	 @Mapping(source = "clazzs", target = "clazzs")
	 ShiftDTO toDTO(Shift shift);  
	
	
	@Mapping (source = "shift_id", target = "id")
	 @Mapping(source = "clazzs", target = "clazzs")
	 Shift toEntity(ShiftDTO shiftDTO);  
}
