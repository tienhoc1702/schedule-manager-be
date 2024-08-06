package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.entities.Admin;
//import com.entities.EducationProgram;
import com.entity.Notification;
@Repository
public interface NotificationDAO extends JpaRepository<Notification, Integer> {

}
