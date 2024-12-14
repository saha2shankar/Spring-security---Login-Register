package com.harishankar.services;

import java.util.List;

import com.harishankar.model.User;

public interface UserService {
	
	public User saveUser(User user);
	public void deleteUser(int id);
	public User updateUser(User user);
	public User getUserbyId(int id);
	public List<User> getAllUser();

}
