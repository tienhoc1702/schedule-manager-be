package com.dto;

import java.sql.Date;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
	Date date;
	String room_code;
	String clazz_code;
	String subject_code;
	String subject_name;
	String instructor_code;
	Integer shift_id;
	LocalTime start_time;
	LocalTime end_time;

}
