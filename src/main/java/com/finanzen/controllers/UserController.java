package com.finanzen.controllers;

import java.util.HashMap;
import java.util.Map;

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
import com.finanzen.models.User;
import com.finanzen.services.UserService;

@RestController
@CrossOrigin (origins= {"http://localhost:4200/"})
@RequestMapping("/api")
public class UserController {

@Autowired UserService userService;
	
	@GetMapping("/user/all")
	public ResponseEntity<?> getAll(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("response", userService.findAll());
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("response", userService.findById(id));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/user/create")
	public ResponseEntity<?> save(@RequestBody User user){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("response", userService.save(user));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<?> update(@RequestBody User user){
		Map<String, Object> response = new HashMap<String, Object>();		
		response.put("response", userService.update(user));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<String, Object>();
		userService.delete(id);
		response.put("response", "Eliminacion exitosa");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/user/byEmailAndPass/{email}/{password}")
	public ResponseEntity<?> byEmailAndPass(@PathVariable String email, @PathVariable String password ){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("response", userService.byEmailAndPass(email, password));
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
