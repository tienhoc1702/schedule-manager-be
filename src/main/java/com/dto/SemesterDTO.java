package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterDTO {
	String semester;
	List<ClazzDTO> clazzs;
	List<StudentDTO> students;
	List<StudyHistoryDTO> studyHistories;
	
}
