package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.entities.Specialization;
//import com.entities.Student;
//import com.entities.StudyHistory;
import com.entity.StudyIn;

import jakarta.transaction.Transactional;
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
	
	///////////////////////////// DOI CA HOC //////////////////////////////////////////
	// Show number student in each clazz
	@Query("SELECT COUNT(si.student.id) FROM StudyIn si "
			+ "WHERE si.student.id IN (SELECT c.id FROM Clazz c JOIN c.subject s "
										+ "WHERE c.id = :clazz_id)")
	Long findNumberStudentByClazzIDAndSubjectCode(
			@Param("clazz_id") Integer clazz_id);
	
	// Show the studyIn of student in what subject in BLOCK, YEAR, SEMESTER
	@Query("SELECT si FROM StudyIn si "
			+ "WHERE si.student.id IN (SELECT st.id FROM Student st WHERE st.code = :student_code) "
			+ "AND si.clazz.id IN (SELECT c.id FROM Clazz c "
									+ "JOIN c.subject s "
									+ "JOIN c.year y " 
								    + "JOIN c.block b "
								    + "JOIN c.semester smt "
									+ "WHERE s.code = :subject_code "
									+ "AND b.block = :block AND y.year = :year AND smt.semester = :semester)")
	List<StudyIn> getStudyIDbyStudentCodeSubjectCode(
			@Param("student_code") String student_code,
		    @Param("subject_code") String subject_code,
		    @Param("block") Integer block,
		    @Param("year") Integer year,
		    @Param("semester") String semester);
	
	@Query("SELECT si FROM StudyIn si "
			+ "WHERE si.clazz.id IN (SELECT c.id FROM Clazz c JOIN c.subject s "
            + "WHERE c.id = :clazz_id) "
            + "AND si.student.id In (SELECT st.id FROM Student st WHERE st.code = :student_code)")
	List<StudyIn> findStudyInByClazzIDAndSubjectCode(
			@Param("clazz_id") Integer clazz_id,
            @Param("student_code") String student_code);
	
	// Update ClazzID from StudyIn ID
	@Modifying
    @Transactional
    @Query("UPDATE StudyIn si SET si.clazz.id = :clazzId WHERE si.id = :id")
    StudyIn updateClazzId(
        @Param("clazzId") Integer clazzId,
        @Param("id") Integer studyID
    );
}
