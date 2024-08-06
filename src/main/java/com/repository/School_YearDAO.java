package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.entities.Admin;
//import com.entities.EducationProgram;
//import com.entities.Register;
import com.entity.School_Year;
@Repository
public interface School_YearDAO extends JpaRepository<School_Year, Integer> {

}
