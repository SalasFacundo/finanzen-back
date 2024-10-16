package com.finanzen.servicesImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.finanzen.services.ExpenseService;
import com.finanzen.specification.ExpenseSpecification;
import com.finanzen.DTO.FilterExpenseDTO;
import com.finanzen.models.Expense;
import com.finanzen.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public List<Expense> findAll() {
		return expenseRepository.findAllOrderByDateDesc();
	}

	@Override
	public Optional<Expense> findById(Long id) {
		return expenseRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}

	@Override
	public Expense save(Expense expense) {
		return expenseRepository.save(expense);
	}

	@Override
	public Expense update(Expense expense) {
		expenseRepository.save(expense);
		return expense;
	}

	@Override
	public List<Expense> filter(FilterExpenseDTO filterExpenseDTO) {
		Specification<Expense> specification = ExpenseSpecification.filtrarDatos(filterExpenseDTO);
		return expenseRepository.findAll(specification);
	}

	@Override
	public List<Expense> findExpensesByMonthAndYear(int month, int year) {
	    List<Expense> allExpenses = expenseRepository.findAll();
	    List<Expense> filteredExpenses = new ArrayList<>();

	    for (Expense expense : allExpenses) {
	        LocalDate expenseDate = expense.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        int monthExpense = expenseDate.getMonthValue();
	        int yearExpense = expenseDate.getYear();

	        if (monthExpense == month && yearExpense == year) {
	            filteredExpenses.add(expense);
	        }
	    }

	    return filteredExpenses;
	}
	
	@Override
	public List<Expense> getExpensesByMonthId(Long monthId, Long userId) {
	    return this.expenseRepository.findByMonthIdAndUserId(monthId, userId);
	}

	@Override
	public Double getSpentAmountByMonthId(Long monthId) {
		return this.expenseRepository.getTotalAmountByMonthId(monthId);
	}


}
