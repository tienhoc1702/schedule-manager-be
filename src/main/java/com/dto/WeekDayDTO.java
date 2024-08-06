package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeekDayDTO {
	Integer id;
	String start_time;
	List<ClazzDTO> clazzs;

	
}
