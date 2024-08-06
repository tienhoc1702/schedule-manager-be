package com.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
	Integer id;	
	String code;	
	String name;
	String email;
	Boolean gender;
	String address;
	String description;
	String avatar;
	Integer area_id;	
}
