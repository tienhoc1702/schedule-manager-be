package com.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="study_histories")
public class StudyHistory implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull(message = "Block cannot be null")
	@ManyToOne
	@JoinColumn(name = "from_block")
	Block block;
	
	@NotNull(message = "Semester cannot be null")
	@ManyToOne
	@JoinColumn(name = "from_semester")
	Semester semester;
	
	@NotNull(message = "Year cannot be null")
	@ManyToOne
	@JoinColumn(name = "from_year")
	School_Year year;
	
	@NotNull(message = "Student cannot be null")
	@ManyToOne
	@JoinColumn(name = "student_id")
	Student student;
	
	@NotNull(message = "Subject cannot be null")
	@ManyToOne
	@JoinColumn(name = "subject_id")
	Subject subject;
	
	@JsonIgnore
	@OneToMany(mappedBy = "studyHistory")
	List<Mark> marks;
	
}
