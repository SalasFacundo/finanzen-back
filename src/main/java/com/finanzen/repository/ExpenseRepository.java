package com.finanzen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finanzen.models.Expense;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>, JpaSpecificationExecutor<Expense>{

	@Query("SELECT e FROM Expense e WHERE FUNCTION('YEAR', e.date) = :year AND FUNCTION('MONTH', e.date) = :month")
	List<Expense> findExpensesByMonth(@Param("month") int month, @Param("year") int year);
	 
	@Query("SELECT e FROM Expense e ORDER BY e.date DESC")
    List<Expense> findAllOrderByDateDesc();	
	
	@Query("SELECT e FROM Expense e WHERE e.monthId = :monthId AND e.userId = :userId")
    List<Expense> findByMonthIdAndUserId(Long monthId, Long userId);
	 
	@Query("SELECT SUM(e.amount) FROM Expense e WHERE e.monthId = :monthId")
	Double getTotalAmountByMonthId(Long monthId);
}
