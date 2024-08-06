package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
	Integer id;
	Integer subject_id;
	Integer student_id;
	Integer clazz_id;
	
}
