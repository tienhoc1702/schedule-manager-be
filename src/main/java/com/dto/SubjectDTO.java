package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
	//Integer id;
    String code;
    String name;
    Integer credits;
    SubjectDTO required;
    List<ApplyForDTO> apply_fors;
    List<ClazzDTO> clazzs;
    List<StudyHistoryDTO> study_histories;
    List<BelongDTO> belongs;
    List<RegisterDTO> registers;	
}
