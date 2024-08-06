package com.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="educationprograms")
public class EducationProgram implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 1, max = 225, message = "Name must be between 1 and 225 characters")
	@Column(name="name", columnDefinition = "nvarchar(225)")
	String name;
	
	@ManyToOne
    @JoinColumn(name = "major_id", nullable = false)
    Major major;
	
	@ManyToOne
    @JoinColumn(name = "from_year", nullable = false)
    School_Year year;
}	
