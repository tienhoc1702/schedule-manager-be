package com.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clazzs")
public class Clazz implements Serializable {
	@Id
	Integer id;
	
	@NotNull(message = "Code cannot be null")
	String code;
	
	@ManyToOne
	@JoinColumn(name = "block_id",nullable = false)
	Block block;
	
	@ManyToOne
	@JoinColumn(name = "semester_id",nullable = false)
	Semester semester;
	
	@ManyToOne
	@JoinColumn(name = "year_id",nullable = false)
	School_Year year;
	
	@ManyToOne
	@JoinColumn(name = "subject_id",nullable = false)
	Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id",nullable = false)
	Instructor instructor;
	
	@ManyToOne
	@JoinColumn(name = "admin_id",nullable = false)
	Admin admin;
	
	@ManyToOne
	@JoinColumn(name = "shift_id",nullable = false)
	Shift shift;
	
	@ManyToOne
	@JoinColumn(name = "weekday_id",nullable = false)
	WeekDay weekDay;
	
	@ManyToOne
	@JoinColumn(name = "room_id",nullable = false)
	Room room;
	
	@JsonIgnore
	@OneToMany(mappedBy = "clazz")
	List<Schedule> schedules;
}
