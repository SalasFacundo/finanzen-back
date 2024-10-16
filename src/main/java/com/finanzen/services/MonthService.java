package com.finanzen.services;

import java.util.List;

import com.finanzen.models.Month;

public interface MonthService {
	
	List<Month> findAll();
	Month findByMonthNumber(Integer id);
	Month findById(Long id);
}
