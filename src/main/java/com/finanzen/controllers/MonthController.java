package com.finanzen.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finanzen.services.MonthService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class MonthController {
	
@Autowired MonthService monthService;
	
	@GetMapping("/month/all")
	public ResponseEntity<?> getAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("months", monthService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/*@GetMapping("/month/{monthNumber}")
	public ResponseEntity<?> getByMonthNumber(@PathVariable Integer monthNumber){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("month", monthService.findByMonthNumber(monthNumber));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}*/
	
	@GetMapping("/month/{id}")
	public ResponseEntity<?> getMonthById(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("month", monthService.findById(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
