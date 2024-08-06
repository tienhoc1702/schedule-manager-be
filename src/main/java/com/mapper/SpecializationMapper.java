package com.mapper;
	
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
	
import com.dto.SpecializationDTO;
import com.entity.Specialization;
	
@Mapper(uses = {AreaMapper.class, TeachForMapper.class, MajorMapper.class, BelongMapper.class})

public interface SpecializationMapper {
	
	SpecializationMapper INSTANCE = Mappers.getMapper(SpecializationMapper.class);  

	@Mapping(source = "area.id", target = "area_id")
	@Mapping(source = "teachFors", target = "teach_fors")
	@Mapping(source = "majors", target = "majors")
	@Mapping(source = "belongs", target = "belongs")
	SpecializationDTO toDTO(Specialization specialization);  
	
	@Mapping(source = "area_id", target = "area.id")
	@Mapping(source = "teach_fors", target = "teachFors")
	@Mapping(source = "majors", target = "majors")
	@Mapping(source = "belongs", target = "belongs")
	Specialization toEntity(SpecializationDTO specializationDTO); 
}
