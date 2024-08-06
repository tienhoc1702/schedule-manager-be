package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.dto.AreaDTO;
import com.entity.Area;


@Mapper(componentModel = "spring")
public interface AreaMapper {

	AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);  

	
	@Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "admins", target = "admins")
	AreaDTO toDTO(Area area);  
    
	@Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "admins", target = "admins")
	Area toEntity(AreaDTO areaDTO); 
	
	List<AreaDTO> toDTOList(List<Area> areas);  
    
	List<Area> toEntityList(List<AreaDTO> areaDTOs);
}
