package com.dto;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftDTO {
	Integer shift_id;
	LocalTime start_time;
	LocalTime end_time;	
	String subject_code;
	String subject_name;	
	String weekDay;
	String intrustor_code;
	List<ClazzDTO> clazzs;

}
