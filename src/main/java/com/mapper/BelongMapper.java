package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.BelongDTO;
import com.entity.Belong;


@Mapper(componentModel = "spring")
public interface BelongMapper {

	BelongMapper INSTANCE = Mappers.getMapper(BelongMapper.class);  

	@Mapping(source = "subject.id", target = "subject_id")
    @Mapping(source = "specialization.id", target = "specialization_id")
    BelongDTO toDTO(Belong belong);

    @Mapping(source = "subject_id", target = "subject.id")
    @Mapping(source = "specialization_id", target = "specialization.id")
    Belong toEntity(BelongDTO belongDTO);
}
