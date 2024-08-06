package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {
	Integer id;
	String code;
	String name;
	List<ClazzDTO> clazzs;
    List<TeachForDTO> teachFors;
}
