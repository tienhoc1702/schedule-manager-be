package com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.AdminDTO;
import com.entity.Admin;

@Mapper(componentModel = "spring")
public interface AdminMapper {

	 AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);  

	 @Mapping(source = "area.id", target = "area_id")
	 AdminDTO toDTO(Admin admin);  
	 
	 @Mapping(source = "area_id", target = "area.id")
	 @Mapping(target = "password", ignore = true)
	 Admin toEntity(AdminDTO adminDTO);  

	 List<AdminDTO> toDTOList(List<Admin> admins);  
	    
	 List<Admin> toEntityList(List<AdminDTO> adminDTOs);
}
