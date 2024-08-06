package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.entities.Admin;
//import com.entities.EducationProgram;
//import com.entities.Register;
import com.entity.Semester;
@Repository
public interface SemesterDAO extends JpaRepository<Semester, String> {

}
