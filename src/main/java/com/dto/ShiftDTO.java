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
	String subject_code;
	String subject_name;
	Integer shift_id;
	String weekDay;
	String intrustor_code;
	List<ClazzDTO> clazzs;

}
