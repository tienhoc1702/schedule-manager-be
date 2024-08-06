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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="marks")
public class Mark implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
	@Column(name="name", columnDefinition = "nvarchar(50)")
	String name;
	
	@Min(value = 0, message = "Percentage must be greater than or equal to 0")
    @Max(value = 100, message = "Percentage must be less than or equal to 100")
	double percentage;
	
	@Min(value = 0, message = "Marked value must be greater than or equal to 0")
	@Max(value = 10, message = "Marked value must be greater than to 10")
	double marked;
	
	
	@ManyToOne
	@JoinColumn(name="study_history_id", nullable = false)
	StudyHistory studyHistory;
}
