package com.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.entity.Note;
@Repository
public interface NoteDAO extends JpaRepository<Note, Integer> {
	@Query("SELECT n " +
		       "FROM Note n " +
		       "JOIN n.student s " +
		       "WHERE s.code = :code " +
		       "AND FUNCTION('MONTH', n.date) = :month " +
		       "AND FUNCTION('YEAR', n.date) = :year")
		List<Note> findNotesByStudentCodeAndMonthAndYear(
		    @Param("code") String code,
		    @Param("month") Integer month,
		    @Param("year") Integer year);
	
	@Query("SELECT n " +
		       "FROM Note n " +
		       "JOIN n.student s " +
		       "WHERE s.code = :code " +
		       "AND n.date = :date")
		List<Note> findNotesByStudentCodeAndDate(
		    @Param("code") String code,
		    @Param("date") Date date);


}
