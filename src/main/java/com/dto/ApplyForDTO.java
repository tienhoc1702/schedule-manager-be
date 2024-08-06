package com.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyForDTO {
	Integer id;
	Integer subject_id;
	Integer education_id;
	String study_semester;
	Integer study_block;
}
