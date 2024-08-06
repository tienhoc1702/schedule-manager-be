package com.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachForDTO {
	Integer id;
	Integer instructor_id;
	Integer specialization_id;	
}
