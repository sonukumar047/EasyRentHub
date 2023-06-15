package com.masaischool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_id", nullable = false)
//	 private Company company;
	
	@Column(name = "property_name", nullable = false, unique = true, length = 50)
	private String propertyName;

	@Column(name = "estd_year", nullable = false)
	int estdYear;
	
	@Column(name = "property_amount", nullable = false)
	private double amount;
	
	@Column(name = "property_location", nullable = false, length = 10)
	private String location;
	
	@Column(name = "property_details", nullable = false)
	private String details;
	
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Property(int id, String propertyName, int estdYear, double amount, String location, String details,
			boolean status) {
		super();
		this.id = id;
		this.propertyName = propertyName;
		this.estdYear = estdYear;
		this.amount = amount;
		this.location = location;
		this.details = details;
		this.status = status;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(String propertyName, int estdYear, double amount, String location, String details) {
		super();
		this.propertyName = propertyName;
		this.estdYear = estdYear;
		this.amount = amount;
		this.location = location;
		this.details = details;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getEstdYear() {
		return estdYear;
	}

	public void setEstdYear(int estdYear) {
		this.estdYear = estdYear;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	
}
