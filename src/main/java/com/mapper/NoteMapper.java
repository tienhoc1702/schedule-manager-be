package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.AreaDTO;
import com.dto.NoteDTO;

import com.entity.Note;

@Mapper(componentModel = "spring")
public interface NoteMapper {

	NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);  

	@Mapping(source = "student.id", target = "student.id")
    @Mapping(source = "noteType.id", target = "notetype_id")
    NoteDTO toDTO(Note note);  
    
    @Mapping(source = "student.id", target = "student.id")
    @Mapping(source = "notetype_id", target = "noteType.id")
    Note toEntity(NoteDTO noteDTO);
    
    List<NoteDTO> toDTOList(List<Note> botes);  
    
	List<Note> toEntityList(List<NoteDTO> noteDTOs);
}
