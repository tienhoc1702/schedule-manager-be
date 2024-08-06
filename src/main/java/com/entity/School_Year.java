package com.entity;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="school_years")
public class School_Year {
	@Id
	Integer year;
	
	@JsonIgnore
	@OneToMany(mappedBy = "year")
	List<EducationProgram> education_programs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "year")
	List<Clazz> clazzs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "year")
	List<Student> students;
	
	@JsonIgnore
	@OneToMany(mappedBy = "year")
	List<StudyHistory> studyHistories;
}
