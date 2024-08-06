package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.entities.Admin;
//import com.entities.EducationProgram;
import com.entity.Major;
@Repository
public interface MajorDAO extends JpaRepository<Major, Integer> {

}
