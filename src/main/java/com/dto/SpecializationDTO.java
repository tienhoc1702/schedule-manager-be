package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationDTO {
	Integer id;
	String name;
	Integer area_id;
	List<TeachForDTO> teach_fors;
	List<MajorDTO> majors;
	List<BelongDTO> belongs;
	
}
