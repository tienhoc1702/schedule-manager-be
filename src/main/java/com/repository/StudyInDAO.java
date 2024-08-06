package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.entities.Specialization;
//import com.entities.Student;
//import com.entities.StudyHistory;
import com.entity.StudyIn;
@Repository
public interface StudyInDAO extends JpaRepository<StudyIn, Integer> {
//	//SO LUONG SINH VIEN CO TRONG CLOP THEO CA VA MA MON
//		@Query("SELECT COUNT(si.clazz.id) " +
//			       "FROM StudyIn si " +
//			       "JOIN si.clazz c " +
//			       "JOIN c.subject sj " +
//			       "WHERE c.code = :clazz_code " + 
//			       "AND c.shift.id = :shift_id " +
//			       "AND sj.code = :subject_code")
//			List<StudyIn> findNumberStudyInClazzByShiftIDAndSubjectCodeAndClazzCode(
//				@Param("clazz_code") String clazz_code,
//			    @Param("shift_id") Integer shift_id,
//			    @Param("subject_code") String subject_code);
	@Query("SELECT COUNT(si) " +
		       "FROM StudyIn si " +
		       "JOIN si.clazz c " +
		       "JOIN c.subject sj " +
		       "WHERE c.code = :clazz_code " + 
		       "AND c.shift.id = :shift_id " +
		       "AND sj.code = :subject_code")
		Integer countStudentsInClazz(@Param("clazz_code") String clazzCode, 
		                          @Param("shift_id") Integer shiftId, 
		                          @Param("subject_code") String subjectCode);

}
