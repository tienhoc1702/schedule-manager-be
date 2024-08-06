package com.dto;


import java.time.LocalTime;
import java.util.Date;

import com.entity.Student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
	Integer id;
	Student student;
	String content;
	Date date;
	LocalTime timeNote;
	Integer notetype_id;
	
}
