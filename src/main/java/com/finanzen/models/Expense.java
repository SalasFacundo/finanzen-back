package com.finanzen.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "expenses")
public class Expense {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String name;
	private double amount;
	private Integer totalQuotes;
	private Integer currentQuote;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Long monthId;
	private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Integer getTotalQuotes() {
		return totalQuotes;
	}
	public void setTotalQuotes(Integer totalQuotes) {
		this.totalQuotes = totalQuotes;
	}	
	public Integer getCurrentQuote() {
		return currentQuote;
	}
	public void setCurrentQuote(Integer currentQuote) {
		this.currentQuote = currentQuote;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getMonthId() {
		return monthId;
	}
	public void setMonthId(Long monthId) {
		this.monthId = monthId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
