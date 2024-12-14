package com.harishankar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harishankar.model.User;
import com.harishankar.repository.UserRepository;
import com.harishankar.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		
	String password =	bCryptPasswordEncoder.encode(user.getPassword());
	user.setPassword(password);
	user.setRole("ROLE_USER");
		
		return repository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public User updateUser(User user) {
		return repository.save(user);
	}

	@Override
	public User getUserbyId(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

}
