package com.finanzen.services;

import java.util.List;
import java.util.Optional;

import com.finanzen.DTO.FilterExpenseDTO;
import com.finanzen.models.Expense;

public interface ExpenseService {

	List<Expense> findAll();
	Optional<Expense> findById(Long id);
	void delete(Long id);
	public Expense save(Expense expense);
	public Expense update(Expense expense);
	public List<Expense> filter(FilterExpenseDTO filterExpenseDTO);
	public List<Expense> findExpensesByMonthAndYear(int month, int year);
	public Double getSpentAmountByMonthId(Long monthId);
	public List<Expense> getExpensesByMonthId(Long id, Long userId);
}
