package com.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyHistoryDTO {
	Integer id;
	Integer block_id;
	String semester_id;
	Integer year_id;
	Integer student_id;
	Integer subject_id;
	List<MarkDTO> marks;
	
}
