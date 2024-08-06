package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dto.BlockDTO;
import com.entity.Block;

@Mapper(componentModel = "spring")
public interface BlockMapper {

	BlockMapper INSTANCE = Mappers.getMapper(BlockMapper.class);  

	@Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "studyHistories", target = "study_histories")
    BlockDTO toDTO(Block block);

    @Mapping(source = "clazzs", target = "clazzs")
    @Mapping(source = "study_histories", target = "studyHistories")
    Block toEntity(BlockDTO blockDTO); 
}
