package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.entities.Admin;
//import com.entities.EducationProgram;
import com.entity.Register;
@Repository
public interface RegisterDAO extends JpaRepository<Register, Integer> {

}
