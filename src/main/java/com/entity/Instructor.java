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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="instructors")
public class Instructor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull(message = "Code cannot be null")
    @Size(min = 1, max = 50, message = "Code must be between 1 and 50 characters")
	String code;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
	@Column(name="name", columnDefinition = "nvarchar(50)")
	String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "instructor")
	List<Clazz> clazzs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "instructor")
	List<TeachFor> teachFors;
	
}
