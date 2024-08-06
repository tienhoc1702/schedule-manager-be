package com.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="blocks")
public class Block implements Serializable {
	@Id
	@Positive(message = "Block ID must be positive")
	Integer block;
	
	@JsonIgnore
	@OneToMany(mappedBy = "block")
	List<Clazz> clazzs;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "block")
	List<StudyHistory> studyHistories;
	
}
