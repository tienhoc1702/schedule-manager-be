package com.dto;

import java.util.List;

import com.entity.StudyHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDTO {
	Integer id;
	String name;
	double percentage;	
	double marked;
	Integer study_history;	
}
