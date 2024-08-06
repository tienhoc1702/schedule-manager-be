package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockDTO {
	Integer block;

	List<ClazzDTO> clazzs;
	
	List<StudyHistoryDTO> study_histories;
}
