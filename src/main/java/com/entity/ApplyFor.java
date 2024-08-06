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
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="apply_for")
public class ApplyFor implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name="subject_id", nullable = false)
    @NotNull(message = "Subject cannot be null")
    Subject subject;

    @ManyToOne
    @JoinColumn(name="education_id", nullable = false)
    @NotNull(message = "Education Program cannot be null")
    EducationProgram education;

    @Column(nullable = false)
    @Positive(message = "Study semester must be positive")
    Integer study_semester;

    @Column(nullable = false)
    @Positive(message = "Study block must be positive")
    Integer study_block;
	
}
