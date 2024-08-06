package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.NoteTypeDTO;
import com.entity.NoteType;

@Mapper(componentModel = "spring")
public interface NoteTypeMapper {

	NoteTypeMapper INSTANCE = Mappers.getMapper(NoteTypeMapper.class);  

	 @Mapping(target = "notes", source = "notes")
	 NoteTypeDTO toDTO(NoteType noteType);  
	    
	 @Mapping(target = "notes", source = "notes")
	 NoteType toEntity(NoteTypeDTO noteTypeDTO);
}
