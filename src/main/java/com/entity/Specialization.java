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
@Table(name="specializations")
public class Specialization implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull(message = "Name cannot be null")
    @Size(max = 50, message = "Name must be at most 50 characters long")
	@Column(name="name", columnDefinition = "nvarchar(50)")
	String name;
	
	@ManyToOne
	@JoinColumn(name="area_id")
	Area area;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "specialization")
	List<TeachFor> teachFors;
	
	@JsonIgnore
	@OneToMany(mappedBy = "specialization")
	List<Major> majors;
	
	@JsonIgnore
	@OneToMany(mappedBy = "specialization")
	List<Belong> belongs;
}	
