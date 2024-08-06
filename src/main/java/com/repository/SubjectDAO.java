package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Subject;
@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {
	@Query("SELECT sub " +
		       "FROM Subject sub " +
		       "WHERE sub.id NOT IN (SELECT sh.subject.id FROM StudyHistory sh "
		       + "JOIN sh.student st WHERE st.code = :code)")
	List<Subject> findSubjectNotInStudyHistory(@Param("code") String code);	
	
}
