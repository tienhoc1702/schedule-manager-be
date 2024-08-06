package com.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="admins")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;

    @NotBlank(message = "Code cannot be blank")
    @Column(nullable = false, unique = true)
     String code;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
     String email;
    
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 6, message = "Name should be at least 6 characters long")
    @Column(name="name", columnDefinition = "nvarchar(50)")
    String name;
    
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password should be at least 6 characters long")
    String password;
    
    @NotNull(message = "Gender cannot be null")
    Boolean gender;
    
    @Column(name="address", columnDefinition = "nvarchar(255)")
	@Size(max = 255, message = "Address must be at most 255 characters long")
    String address;
    
    @Column(name="description", columnDefinition = "nvarchar(225)")
	@Size(max = 255, message = "Description must be at most 255 characters long")
    String description;
    
    String avatar;
    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    Area area;
}
