package com.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.ClazzDTO;
import com.entity.Clazz;


@Repository
public interface ClazzDAO extends JpaRepository<Clazz, Integer> {
		
		@Query("SELECT c " +
		       "FROM Clazz c " +
		       "JOIN c.subject sub " +
		       "WHERE c.shift.id = :shift_id " +
		       "AND sub.code = :subject_code")
		List<Clazz> findClazzByShiftIDAndSubjectCode(
			@Param("shift_id") Integer shift_id,
		    @Param("subject_code") String subject_code);
		
		// MON HOC HIEN TAI (CA HOC HIEN TAI) - StudentCODE,SubjectCODE,ShiftID
		@Query("SELECT c " +
			       "FROM Clazz c " +
			       "JOIN c.subject sub " +
			       "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :code) " +
			       "AND sub.code = :subject_code AND c.shift.id = :shift_id")
			List<Clazz> findClazzByStudentCodeAndSubjectCodeAndShiftID(
					@Param("code") String code,
				    @Param("subject_code") String subject_code,
				    @Param("shift_id") Integer shift_id);
		@Query("SELECT c.code, " +
		           "s.name, " +
		           "s.code, " +
		           "i.code, " +
		           "c.shift.id, " +
		           "sh.start_time, " +
		           "sh.end_time, " +
		           "c.weekDay.id, " +
		           "r.id " +
		           "FROM Clazz c " +
		           "JOIN c.subject s " +
		           "JOIN c.instructor i " +
		           "JOIN c.shift sh " +
		           "JOIN c.room r " +
		           "JOIN StudyIn si ON si.clazz.id = c.id " +
		           "JOIN Student st ON si.student.id = st.id " +
		           "WHERE st.code = :code " +
		           "AND sh.id = :shiftId")
		    List<Object[]> findCurrentClassesByStudentCodeAndShift(@Param("code") String code, @Param("shiftId") Integer shiftId);
	
		    
		    
		    /////////////////////////////////// DOI CA HOC /////////////////////////////////	
		  		    
		    
		    //Show Clazz of the student code in block,year,semester
			@Query("SELECT c " +
				       "FROM Clazz c " +
				       "JOIN c.year y " +
				       "JOIN c.block b " +
				       "JOIN c.semester smt " +
				       "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :code) " +
				       "AND b.block = :block AND y.year = :year AND smt.semester = :semester")
				List<Clazz> findClazzByStudentCodeAndBlockAndYearAndSemester(
						@Param("code") String code,
					    @Param("block") Integer block,
					    @Param("year") Integer year,
					    @Param("semester") String semester);
			
			//Show Clazz of the student code in subject code
			@Query("SELECT c " +
				       "FROM Clazz c " +
				       "JOIN c.subject sub " +
				       "JOIN c.year y " +
				       "JOIN c.block b " +
				       "JOIN c.semester smt " +
				       "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :student_code) " +
				       "AND sub.code = :subject_code "
				       + "AND b.block = :block AND y.year = :year AND smt.semester = :semester")
			List<Clazz> findClazzByStudentCodeAndSubjectCode(
						@Param("student_code") String code,
						@Param("subject_code") String subject_code,
						@Param("block") Integer block,
					    @Param("year") Integer year,
					    @Param("semester") String semester);
			
			// Show ALL Clazz having that subject_code in what Shift
			@Query("SELECT c " +
				       "FROM Clazz c " +
				       "JOIN c.subject sub " +
				       "JOIN c.shift sh " +
				       "JOIN c.year y " +
				       "JOIN c.block b " +
				       "JOIN c.semester smt " +
				       "WHERE sub.code = :subject_code AND sh.id = :shift_id "
				       + "AND b.block = :block AND y.year = :year AND smt.semester = :semester")
			List<Clazz> findClazzBySubjectCodeAndShiftID(
						@Param("subject_code") String subject_code,
					    @Param("shift_id") Integer shift_id,
					    @Param("block") Integer block,
					    @Param("year") Integer year,
					    @Param("semester") String semester);
			
				
}
