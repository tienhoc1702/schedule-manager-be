package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.StudyHistory;
public interface StudyHistoryDAO extends JpaRepository<StudyHistory, Integer> {
	@Query("SELECT sh " +
		       "FROM StudyHistory sh " +
		       "JOIN sh.subject sub " +
		       "JOIN sh.student st " +
		       "WHERE st.code = :code")
	List<StudyHistory> findStudyHistoryByStudentCode(@Param("code") String code);
	
	
}
