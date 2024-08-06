package com.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="students")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotBlank(message = "Code cannot be blank")
    @Size(max = 20, message = "Code must be at most 20 characters long")
	String code;
	
	@NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name must be at most 50 characters long")
    @Column(name="firstName", columnDefinition = "nvarchar(50)")
	String firstName;
	
	@NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name must be at most 50 characters long")
    @Column(name="lastName", columnDefinition = "nvarchar(50)")
	String lastName;
	
	@NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
	String email;
	
	@NotBlank(message = "Password cannot be blank")
	String password;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	Date brithday;
	
	@NotNull(message = "Gender cannot be null")
	Boolean gender= false;
	
	@Size(max = 10, message = "Phone number must be at most 10 characters long")
	String phone;
	
	@Column(name="address", columnDefinition = "nvarchar(255)")
	@Size(max = 255, message = "Address must be at most 255 characters long")
	String address;
	
	@Column(name="description", columnDefinition = "nvarchar(225)")
	@Size(max = 255, message = "Description must be at most 255 characters long")
	String description;
	
	@Size(min = 5, message = "Avatar must be at most 5 characters less")
	String avatar;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "enter_school")
	Date enterSchool;
	
	@NotNull(message = "Course cannot be null")
	String course;
	
	@ManyToOne
	@JoinColumn(name = "major_id")
 	Major major;
	
		
	@ManyToOne
	@JoinColumn(name = "from_semester")
	Semester semester;
	
	@ManyToOne
	@JoinColumn(name = "from_year")
	School_Year year;
	
	@ManyToOne
	@JoinColumn(name = "education_id")
	EducationProgram educationProgram;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	List<StudyHistory> studyHistories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	List<Note> notes;
}
