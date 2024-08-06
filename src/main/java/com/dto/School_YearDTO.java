package com.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School_YearDTO {
	Integer year;
	List<EducationProgramDTO> education_programs;
	List<ClazzDTO> clazzs;
	List<StudentDTO> students;
	List<StudyHistoryDTO> studyHistories;

}
