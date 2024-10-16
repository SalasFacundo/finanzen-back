package com.finanzen.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzen.models.Month;
import com.finanzen.repository.MonthRepository;
import com.finanzen.services.MonthService;


@Service
public class MonthServiceImpl implements MonthService{
	
	@Autowired
	MonthRepository monthRepository;

	@Override
	public List<Month> findAll() {
		return monthRepository.findAll();
	}

	@Override
	public Month findByMonthNumber(Integer id) {		
		return monthRepository.findByMonth(id);
	}

	@Override
	public Month findById(Long id) {		
		return monthRepository.findById(id).orElse(null);
	}

	

}
