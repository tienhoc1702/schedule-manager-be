package com.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ClazzDTO;
import com.dto.ShiftDTO;
import com.dto.StudyInDTO;
import com.entity.Clazz;
import com.entity.StudyIn;
import com.mapper.ClazzMapper;
import com.mapper.ShiftMapper;
import com.mapper.StudyInMapper;
import com.repository.StudyInDAO;
import com.service.ClazzService;
import com.service.ShiftService;
import com.service.StudyInService;

@RestController
public class ScheduleChangeController {
	@Autowired
    ClazzMapper clazzMapper;
    
    @Autowired
    ClazzService clazzService;
    
    @Autowired
    StudyInMapper studyInMapper;
    
    @Autowired
    StudyInService studyInService;
    
    @Autowired
    StudyInDAO studyIndao;
    
    @Autowired
    ShiftMapper shiftMapper;
    
    @Autowired
    ShiftService shiftService;
    
    //Show Clazz of the student code in block,year,semester
  	@GetMapping("/api/predict")
    public List<ClazzDTO> getClazzByStudentCodeAndBlockAndYearAndSemester(
      			@RequestParam String student_code,
      			@RequestParam Integer block,
      			@RequestParam Integer year,
      			@RequestParam String semester) {
  		return clazzService.findClazzByStudentCodeAndBlockAndYearAndSemester(student_code, block, year,semester);
    }
  	
  	//Show Clazz of the student code in subject code
  	@GetMapping("/api/predict/this")
    public List<ClazzDTO> getClazzByStudentCodeAndSubjectCode(
      			@RequestParam String student_code,
      			@RequestParam String subject_code,
      			@RequestParam Integer block,
      			@RequestParam Integer year,
      			@RequestParam String semester) {
  		return clazzService.findClazzByStudentCodeAndSubjectCode(student_code, subject_code, block, year, semester);
    }
  	
  	@GetMapping("/api/shift")
	public List<ShiftDTO> showAllShiftbyBlockYearSemester(
				@RequestParam Integer block,
				@RequestParam Integer year,
				@RequestParam String semester){
		return shiftService.showAllShiftbyBlockYearSemester(block, year, semester);
	}
  	
  	// Show ALL Clazz having that subject_code in what Shift
 	@GetMapping("/api/Clazzes")
    public List<ClazzDTO> getClazzBySubjectCodeAndShiftID(
             	@RequestParam String subject_code,
             	@RequestParam Integer shift_id,
             	@RequestParam Integer block,
             	@RequestParam Integer year,
             	@RequestParam String semester) {
    return clazzService.findClazzBySubjectCodeAndShiftID(subject_code, shift_id,block, year, semester);
    }
 	
 	// Show number student by clazz id and subject code // co van de
 	@GetMapping("/api/countStudied")
    public StudyInDTO getStudyInDTOWithCount(
     			@RequestParam Integer clazz_id) { // bo subject code
         return studyInService.getStudyInDTOWithCount(clazz_id);
    }
 	
 	//thay doi ca - Lay ID StudyIN 	
 	@GetMapping("/api/clazz/changed/{studyIn_id}")
 	public List<StudyInDTO> getOne(@PathVariable("studyIn_id") Integer studyIn_id) {
 		return studyInService.findById(studyIn_id);
 	}
 	
 	@GetMapping("/api/clazz/changed-of")
 	public List<StudyInDTO> getStudyIDbyStudentCodeSubjectCode(
 				@RequestParam String student_code,
 				@RequestParam String subject_code,
 				@RequestParam Integer block,
 				@RequestParam Integer year,
 				@RequestParam String semester) {
 		return studyInService.getStudyIDbyStudentCodeSubjectCode(student_code,subject_code,block,year,semester);
 	} 	
 	// thay doi ca - Tu ID StudyIn thay doi ID Clazz
 	@PutMapping("/api/clazz/changed")
    public List<StudyInDTO> putOne(
     			@RequestParam Integer studyIn_id, 
     			@RequestBody StudyIn studyIn,
     			@RequestParam Clazz other_clazzID) { 		
 		Optional<StudyIn> existingStudyIn = studyIndao.findById(studyIn_id); 		
 		if (existingStudyIn.isPresent()) { 			
 			StudyIn existingID = existingStudyIn.get(); 			
 			existingID.setClazz(other_clazzID);
 			studyIndao.save(existingID);
 		} 		
 		Optional<StudyIn> studyInList = studyIndao.findById(studyIn_id);
 		return studyInList.stream()
                 .map(StudyInMapper.INSTANCE::toDTO)
                 .collect(Collectors.toList());
 	}
}
