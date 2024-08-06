package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Schedule;
import com.entity.StudyIn;
@Repository
public interface ScheduleDAO extends JpaRepository<Schedule, Integer> {
	
	// lich hoc
	@Query("SELECT s " +
	           "FROM Schedule s " +
	           "JOIN s.clazz c " +
	           "JOIN c.room r " +
	           "JOIN c.subject subj " +
	           "JOIN c.instructor i " +
	           "JOIN c.shift sh " +
	           "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :code) " +
	           "AND s.date BETWEEN :startDate AND :endDate " +
	           "ORDER BY s.date ASC")
		List<Schedule> findSchedulesByStudentCodeAndDateRange(
		    @Param("code") String code,
		    @Param("startDate") LocalDate startDate,
		    @Param("endDate") LocalDate endDate);
	
	
	
	
	// DOI LICH HOC & MON HOC DU KIEN
	@Query("SELECT s " +
		       "FROM Schedule s " +
		       "JOIN s.clazz c " +
		       "JOIN c.subject subj " +
		       "JOIN c.year y " +
		       "JOIN c.block b " +
		       "JOIN c.semester smt " +
		       "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :code) " +
		       //"AND subj.id NOT IN (SELECT his.subject.id FROM StudyHistory his WHERE his.student.code = :code) " +
		       "AND b.block = :block AND y.year = :year AND smt.semester = :semester")
		List<Schedule> findSchedulesByStudentCodeAndBlockAndYear(
		    @Param("code") String code,
		    @Param("block") Integer block,
		    @Param("year") Integer year,
		    @Param("semester") String semester);
	//c.subject.code,c.subject.name,c.shift.id,c.weekDay.start_time,c.instructor.code
	@Query("SELECT s " +
		       "FROM Schedule s " +
		       "JOIN s.clazz c " +
		       "JOIN c.subject sj " +
		       "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :code) " +
		       "AND sj.code = :subject_code")
		List<Schedule> findSchedulesByStudentCodeAndSubjectCode(
		    @Param("code") String code,
		    @Param("subject_code") String subject_code);
	
	@Query("SELECT s " +
		       "FROM Schedule s " +
		       "JOIN s.clazz c " +
		       "JOIN c.subject sj " +
		       "JOIN c.shift sh " +
		       "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :code) " +
		       "AND sj.code = :subject_code "+ 
		       "AND sh.id = :shift_id")
		List<Schedule> findSchedulesByStudentCodeAndSubjectCodeAndShiftID(
		    @Param("code") String code,
		    @Param("subject_code") String subject_code,
		    @Param("shift_id") Integer shift_id);
	
	
	
	
	// exam schedule
	@Query("SELECT s " +
	           "FROM Schedule s " +
	           "JOIN s.clazz c " +
	           "JOIN c.subject subj " +
	           "WHERE c.id IN (SELECT si.clazz.id FROM StudyIn si WHERE si.student.code = :code) " +
	           "AND s.date BETWEEN :startDate AND :endDate " +
	           "ORDER BY subj.name, s.date DESC")
	    List<Schedule> findAllSchedulesByStudentCode(
	        @Param("code") String code,
	        @Param("startDate") LocalDate startDate,
	        @Param("endDate") LocalDate endDate);
}
