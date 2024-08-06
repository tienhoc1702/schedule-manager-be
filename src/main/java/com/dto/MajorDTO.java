package com.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDTO {
	Integer id;
	String name;
	Integer specialization;
	List<EducationProgramDTO> educations;
	List<StudentDTO> students;
	
}
