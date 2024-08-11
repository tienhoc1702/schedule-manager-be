package com.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ShiftDTO;
import com.entity.Shift;
import com.mapper.ShiftMapper;
import com.repository.ShiftDAO;

@Service
public class ShiftService {
	@Autowired
	ShiftDAO dao;	 
	 
	public List<ShiftDTO> showAllshift(){
		List<Shift> list = dao.findAll();
		return list.stream()
			 .map(ShiftMapper.INSTANCE::toDTO)
             .collect(Collectors.toList());
	}
	 
	public List<ShiftDTO> showAllShiftbyBlockYearSemester(Integer block,Integer year,String semester){
		List<Shift> list = dao.showAllShiftbyBlockYearSemester(block, year, semester);
		return list.stream()
			 .map(ShiftMapper.INSTANCE::toDTO)
             .collect(Collectors.toList());
	}
}
