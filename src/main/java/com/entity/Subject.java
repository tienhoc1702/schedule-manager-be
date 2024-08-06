package com.entity;

import java.io.Serializable;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subjects")
public class Subject implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull(message = "Code cannot be null")
	String code;
	
	@NotNull(message = "Name cannot be null")
	@Column(name="name", columnDefinition = "nvarchar(255)", nullable = false)
	String name;
	
	@NotNull(message = "Credits cannot be null")
    @Column(nullable = false)
	Integer credits;
	
	@NotNull(message = "Hours cannot be null")
    @Column(nullable = false)
	Integer hours;
	
	@ManyToOne
	@JoinColumn(name ="required_id")
	Subject required;
	
	@OneToMany(mappedBy = "required")
	List<Subject> requiredSubjects;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	List<ApplyFor> applyFors;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	List<Clazz> clazzs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	List<StudyHistory> studyHistories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	List<Belong> belongs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subject")
	List<Register> registers;
}
