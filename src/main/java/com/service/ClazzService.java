package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ClazzDTO;
import com.entity.Clazz;
import com.mapper.ClazzMapper;
import com.repository.ClazzDAO;

@Service
public class ClazzService {
	@Autowired
    private ClazzDAO dao;

    public List<ClazzDTO> findClazzByStudentCodeAndBlockAndYearAndSemester(String student_code, Integer block, Integer year,String semester) {
        List<Clazz> clazzList = dao.findClazzByStudentCodeAndBlockAndYearAndSemester(student_code, block, year,semester);
        return clazzList.stream()
                        .map(ClazzMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList());
    }
    
    public List<ClazzDTO> findClazzByStudentCodeAndSubjectCode(String student_code,String subject_code, Integer block, Integer year,String semester) {
        List<Clazz> clazzList = dao.findClazzByStudentCodeAndSubjectCode(student_code,subject_code,block,year,semester);
        return clazzList.stream()
                        .map(ClazzMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList());
    }
    
    public List<ClazzDTO> findClazzBySubjectCodeAndShiftID(String subject_code,Integer shift_id,Integer block, Integer year,String semester) {
        List<Clazz> clazzList = dao.findClazzBySubjectCodeAndShiftID(subject_code,shift_id,block,year,semester);
        return clazzList.stream()
                        .map(ClazzMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList());
    }
}
