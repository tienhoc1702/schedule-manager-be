package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.entities.Admin;
//import com.entities.EducationProgram;
import com.entity.Mark;
@Repository
public interface MarkDAO extends JpaRepository<Mark, Integer> {
	@Query("SELECT sub.code, sub.name, sub.credits, SUM(m.marked * m.percentage) / 100 " +
		       "FROM Mark m " +
		       "JOIN m.studyHistory sh " +
		       "JOIN sh.student s " +
		       "JOIN sh.subject sub " +
		       "WHERE s.code = :code " + 
		       "AND sub.code IN ("
						       + "SELECT sub.code "
						       + "FROM StudyHistory sh "
						       + "JOIN sh.student st "
						       + "JOIN sh.subject sub "
						       + "WHERE st.code = :code"
						       + ") " + 
		       "GROUP BY sub.code, sub.name, sub.credits " + 
		       "HAVING SUM(m.marked * m.percentage) / 100 < 5 ")
		List<Mark> findSubjectUnder5byStudentCode(@Param("code") String code);
}
