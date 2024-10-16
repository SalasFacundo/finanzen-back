package com.finanzen.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finanzen.DTO.FilterExpenseDTO;
import com.finanzen.models.Expense;
import com.finanzen.services.ExpenseService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class ExpenseController {
	
	@Autowired ExpenseService expenseService;
	
	@GetMapping("/expense/all")
	public ResponseEntity<?> getAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("expenses", expenseService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/expense/{id}")
	public ResponseEntity<?> getAll(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("expenses", expenseService.findById(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/expense/create")
	public ResponseEntity<?> save(@RequestBody Expense expense){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("expense", expenseService.save(expense));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/expense/update")
	public ResponseEntity<?> update(@RequestBody Expense expense){
		Map<String, Object> response = new HashMap<String, Object>();		
		response.put("expense", expenseService.update(expense));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/expense/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		expenseService.delete(id);
		response.put("expense", "Eliminacion exitosa");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/expense/filter")
	public ResponseEntity<?> filter(@RequestBody FilterExpenseDTO filter){
		Map<String, Object> response = new HashMap<String, Object>();		
		response.put("filter", expenseService.filter(filter));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/expense/getSpentAmountByMonthId/monthId")
	public ResponseEntity<?> getSpentAmountByMonthId(@PathVariable Long monthId){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("expenses", expenseService.getSpentAmountByMonthId(monthId));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/expense/byMonthIdAndUserId/{monthId}/{userId}")
	public ResponseEntity<?> getExpensesByMonthID(@PathVariable Long monthId, @PathVariable Long userId){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("expenses", expenseService.getExpensesByMonthId(monthId, userId));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
