package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import com.entities.Specialization;
//import com.entities.Student;
//import com.entities.StudyHistory;
//import com.entities.StudyIn;
//import com.entities.Subject;
//import com.entities.TeachFor;
import com.entity.WeekDay;
public interface WeekDayDAO extends JpaRepository<WeekDay, Integer> {

}
