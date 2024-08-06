package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.entities.Admin;
import com.entity.Instructor;
@Repository
public interface InstructorDAO extends JpaRepository<Instructor, Integer> {

}
