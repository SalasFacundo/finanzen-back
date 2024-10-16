package com.finanzen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.finanzen.models.Month;

public interface MonthRepository extends JpaRepository<Month, Long> {
	
	@Query("SELECT m FROM Month m WHERE m.month = :month")
    Month findByMonth(@Param("month") Integer month);
}
