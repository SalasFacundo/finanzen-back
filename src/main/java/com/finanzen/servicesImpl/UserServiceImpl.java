package com.finanzen.servicesImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finanzen.models.User;
import com.finanzen.repository.UserRepository;
import com.finanzen.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public User byEmailAndPass(String email, String password) {		 
		return userRepository.findByEmailAndPassword(email, password);
	}

}
