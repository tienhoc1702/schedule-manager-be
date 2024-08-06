package com.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BelongDTO {
	Integer id;
	Integer subject_id;
	Integer specialization_id;	
}
