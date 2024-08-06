package com.dto;
import java.util.Date;
import java.util.List;

import com.entity.StudyHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO{ 
    String code;  
    String firstName;
    String lastName;
    String email;   
    Date brithday;  
    Boolean gender;  
    String phone;  
    String address;  
    String description; 
    String avatar;
    String major_name;
    String course;
    Date enter_school;
    String educationProgram_name; 
    List<StudyHistoryDTO> studyHistories;
    List<NoteDTO> notes;
}
