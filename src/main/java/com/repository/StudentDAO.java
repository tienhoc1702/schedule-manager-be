package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Student;
@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	@Query("SELECT o FROM Student o WHERE o.code = :code")
	List<Student> findStudentByCode(@Param("code") String code);
	
}
