package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationProgramDTO {
	Integer id;
	String name;
	Integer major_id;
	Integer year_id;	
}
