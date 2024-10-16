package com.finanzen.services;
import java.util.List;
import java.util.Optional;
import com.finanzen.models.User;


public interface UserService {	
	List<User> findAll();
	Optional<User> findById(Long id);
	void delete(Long id);
	public User save(User user);
	public User update(User user);
	public User byEmailAndPass(String email, String password);
}
