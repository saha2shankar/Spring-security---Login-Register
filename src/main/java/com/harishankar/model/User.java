package com.harishankar.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String mobileNo;
	private String email;
	private String password;
	private String role;
	private LocalDateTime createDate;
	
	private User() {
		this.createDate = LocalDateTime.now();
	}

}
