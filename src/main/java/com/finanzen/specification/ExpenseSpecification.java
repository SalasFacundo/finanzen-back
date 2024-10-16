package com.finanzen.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.finanzen.models.Expense;
import com.finanzen.DTO.FilterExpenseDTO;

public class ExpenseSpecification {
	
	/*private String type;
	private String name;
	private BigDecimal minAmount;
	private BigDecimal maxAmount;
	private Date startDate;
	private Date endDate;*/
	
	public static Specification<Expense> filtrarDatos(FilterExpenseDTO filtro) {
        return new Specification<Expense>() {
        	 @Override
             public Predicate toPredicate(Root<Expense> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                 Predicate predicate = criteriaBuilder.conjunction();
                 
                 if (filtro.getType() != null && filtro.getType().trim() != "") {
                     predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("type"), filtro.getType()));
                 }
                 if (filtro.getName() != null && filtro.getName().trim() != "") {
                     predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), filtro.getName()));
                 }
                 if (filtro.getMinAmount() != null) {
                     predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), filtro.getMinAmount()));
                 }
                 if (filtro.getMaxAmount() != null) {
                     predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("amount"), filtro.getMaxAmount()));
                 }
                 if (filtro.getStartDate() != null) {
                     predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("date"), filtro.getStartDate()));
                 }
                 if (filtro.getEndDate() != null) {
                     predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("date"), filtro.getEndDate()));
                 }                 
                 return predicate;
             }
        };
    }
}
