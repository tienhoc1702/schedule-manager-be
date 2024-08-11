package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dto.ClazzDTO;
//import com.entities.Admin;
//import com.entities.EducationProgram;
//import com.entities.Register;
import com.entity.Shift;
@Repository
public interface ShiftDAO extends JpaRepository<Shift, Integer> {
	@Query("SELECT sh " +
		       "FROM Shift sh " + 
		       "JOIN sh.clazzs c " +
		       "JOIN c.year y " +
		       "JOIN c.block b " +
		       "JOIN c.semester smt " +
		       "WHERE b.block = :block AND y.year = :year AND smt.semester = :semester ")
	List<Shift> showAllShiftbyBlockYearSemester(
			    @Param("block") Integer block,
			    @Param("year") Integer year,
			    @Param("semester") String semester);
	
}
