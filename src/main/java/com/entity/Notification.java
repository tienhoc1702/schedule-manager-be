package com.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="notification")
public class Notification implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull(message = "Sender cannot be null")
    @Size(max = 100, message = "Sender must be less than or equal to 100 characters")
    @Column(name="sender", columnDefinition = "nvarchar(100)")
    String sender;

    @NotNull(message = "Receiver cannot be null")
    @Size(max = 100, message = "Receiver must be less than or equal to 100 characters")
    @Column(name="receiver", columnDefinition = "nvarchar(100)")
    String receiver;

    @NotNull(message = "Content cannot be null")
    @Size(max = 500, message = "Content must be less than or equal to 255 characters")
    @Column(name="content", columnDefinition = "nvarchar(255)")
    String content;
}
