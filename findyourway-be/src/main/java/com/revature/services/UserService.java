package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	
	public User addUser(User newUser);
	public List<User> findAllUsers();
	public User findUserById(Integer id);
	public User findUserByEmail(String email);
	public User findUserByFirstname(String firstname);
	public User findUserByLastname(String lastname);
	public User findUserByLocation(String location);
	public User updateUserById(User u);
	public void deleteUserById(Integer id);
	public User loginUser(User u);
	
	public boolean isEmailUnique(User u);
}
