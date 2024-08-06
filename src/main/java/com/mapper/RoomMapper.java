package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.RoomDTO;
import com.entity.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {

	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);  

	@Mapping(target = "clazzs", source = "clazzs")
    RoomDTO toDTO(Room room);  
    
    @Mapping(target = "clazzs", source = "clazzs")
    Room toEntity(RoomDTO roomDTO);  
}
