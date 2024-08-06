package com.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="semesters")
public class Semester implements Serializable {
	@Id
	String semester;
	
	@JsonIgnore
	@OneToMany(mappedBy = "semester")
	List<Clazz> clazzs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "semester")
	List<Student> students;
	
	@JsonIgnore
	@OneToMany(mappedBy = "semester")
	List<StudyHistory> studyHistories;
}
