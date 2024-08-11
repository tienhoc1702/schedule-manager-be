package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dto.NotesCountDTO;
import com.entity.Note;

public interface NoteDAO extends JpaRepository<Note, Integer> {
	
	//Find notes by date
	@Query("SELECT n " +
		       "FROM Note n " +
		       "JOIN n.student s " +
		       "WHERE s.code = :code " +
		       "AND FUNCTION('DAY', n.date) = :day " +
		       "AND FUNCTION('MONTH', n.date) = :month " +
		       "AND FUNCTION('YEAR', n.date) = :year")
	List<Note> findNotesByDate(
		    @Param("code") String code,
		    @Param("day") Integer day,
		    @Param("month") Integer month,
		    @Param("year") Integer year);

	 //Count notes
	 @Query("SELECT new com.dto.NotesCountDTO(" +
		       "SUM(CASE WHEN nt.id = 1 THEN 1 ELSE 0 END)," +
		       "SUM(CASE WHEN nt.id = 2 THEN 1 ELSE 0 END))" +
		       "FROM Note n " +
		       "JOIN n.noteType nt " +
		       "JOIN n.student s " +
		       "WHERE FUNCTION('MONTH', n.date) = :month " +
		       "AND s.code = :code " +
		       "GROUP BY FUNCTION('MONTH', n.date) " +
		       "ORDER BY FUNCTION('MONTH', n.date)")
		NotesCountDTO findNotesByMonthAndStudentCode(@Param("month") int month, @Param("code") String code);

}
