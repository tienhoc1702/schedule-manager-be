package com.dto;
import java.time.LocalTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
	Integer id;
	Integer student_id;
	String student_code;
	String content;
	String location;
	Date date;
	LocalTime timeNote;
	Integer notetype_id;
	
}
