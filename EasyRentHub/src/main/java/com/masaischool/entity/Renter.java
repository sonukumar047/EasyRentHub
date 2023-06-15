package com.masaischool.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Renter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)	//this is for not null
	private String name;
	
	@Column(unique = true, length = 50, nullable = false)	//this is for making it unique
	private String username;
	
	@Column(nullable = false, length = 50)
	private String password;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	public Renter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Renter(String name, String username, String password, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}
