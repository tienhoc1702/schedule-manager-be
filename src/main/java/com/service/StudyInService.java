package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.StudyInDTO;
import com.entity.StudyIn;
import com.mapper.StudyInMapper;
import com.repository.StudyInDAO;

@Service
public class StudyInService {
	@Autowired
	private StudyInDAO dao;
	
	public List<StudyInDTO> findStudyInByClazzIDAndSubjectCode(Integer clazz_id, String student_code) {
        List<StudyIn> studyInList = dao.findStudyInByClazzIDAndSubjectCode(clazz_id, student_code);
        return studyInList.stream()
                        .map(StudyInMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList());
    }
	
	public StudyInDTO getStudyInDTOWithCount(Integer clazzId) {
        // Fetch the count of students
        Long count = dao.findNumberStudentByClazzIDAndSubjectCode(clazzId);

        // Create a StudyInDTO and set the count to the SL field
        StudyInDTO studyInDTO = new StudyInDTO();
        studyInDTO.setSL(count.intValue()); // Convert Long to Integer

        return studyInDTO;
    }
	
	public List<StudyInDTO> getStudyIDbyStudentCodeSubjectCode(
			String student_code, String subject_code,
			Integer block, Integer year, String semester ) {
        List<StudyIn> studyInList = dao.getStudyIDbyStudentCodeSubjectCode(student_code, subject_code,block,year,semester);
        return studyInList.stream()
                        .map(StudyInMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList());
    }
	
	
	public StudyInDTO updateClazzId(Integer clazzId, Integer studyID) {
		StudyIn st = dao.updateClazzId(clazzId, studyID);
		
		StudyInDTO studyInDTO = new StudyInDTO();
		studyInDTO.setClazz_id(clazzId);
		
		return studyInDTO;
	}

	public List<StudyInDTO> findById(Integer studyIn_id) {
		Optional<StudyIn> studyInList = dao.findById(studyIn_id);
		return studyInList.stream()
                .map(StudyInMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
	}
	
	@Autowired
	 private StudyInMapper studyInMapper;
	 
	 public StudyInDTO update(StudyInDTO existingID) {
		 
       // Convert DTO to Entity
       StudyIn studyIn = studyInMapper.toEntity(existingID);
               
       // Save the entity
       studyIn = dao.save(studyIn);

       // Convert back to DTO
       return studyInMapper.toDTO(studyIn);
   }
}
