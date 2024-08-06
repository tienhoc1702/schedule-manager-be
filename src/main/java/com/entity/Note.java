package com.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="notes")
public class Note implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
	
	
    @Size(max = 225, message = "Content must be less than or equal to 225 characters")
	@Column(name="content", columnDefinition = "nvarchar(225)")
	String content;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	Date date;
	
	@NotNull(message = "Time cannot be null")
	LocalTime timeNote;
	
	@ManyToOne
	@JoinColumn(name = "type_id", nullable = false)
	NoteType noteType;
}
