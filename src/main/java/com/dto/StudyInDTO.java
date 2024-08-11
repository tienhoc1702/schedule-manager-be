package com.dto;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyInDTO {
	Integer studyin_id;
	Integer clazz_id;
	Integer student_id;
	String student_code;
	Integer subject_id;
	String subject_name;
	String subject_code;
	Integer subject_credit;
	Integer block;
	String semester_id;
	Integer year;	
	String instructor_code;
	Integer shift_id;
	LocalTime start_time;
	LocalTime end_time;
	String weekday_date;
	String room;	
	Integer SL;
}
