package com.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzDTO {
	Integer id;
	String code;
	Integer block_id;
	String semester_id;
	Integer year_id;
	String subject_name;
	String subject_code;
	Integer subject_credit;
	String instructor_code;
	String admin_name;
	Integer shift_id;
	LocalTime start_time;
	LocalTime end_time;
	Integer weekday_id;
	String room_id;
	List<ScheduleDTO> schedules;

	
	
}
