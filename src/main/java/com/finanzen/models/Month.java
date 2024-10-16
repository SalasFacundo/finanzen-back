package com.finanzen.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "months")
public class Month {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double availableAmount;
	Integer month;
	Integer year;
	boolean isFinalized;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(Double availableAmount) {
		this.availableAmount = availableAmount;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public boolean isFinalized() {
		return isFinalized;
	}
	public void setFinalized(boolean isFinalized) {
		this.isFinalized = isFinalized;
	}	
}
