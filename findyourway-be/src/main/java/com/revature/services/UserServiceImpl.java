package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User addUser(User newUser) {
		for(User user : findAllUsers()) {
			if(user.getUsername().equals(newUser.getUsername()) 
					|| user.getEmail().equals(newUser.getEmail())) {
				return null;
			}
		}
		return userRepo.save(newUser);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		return userRepo.getOne(id);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	@Override
	public User findUserByFirstname(String firstname) {
		return userRepo.findUserByFirstname(firstname);
	}

	@Override
	public User findUserByLastname(String lastname) {
		return userRepo.findUserByLastname(lastname);
	}

	@Override
	public User findUserByLocation(String location) {
		return userRepo.findUserByLocation(location);
	}

	@Override
	public User updateUserById(User u) {
		return userRepo.save(u);
	}

	@Override
	public boolean deleteUser(User u) {
		userRepo.delete(u);
		return !userRepo.existsById(u.getUserId());
	}

	@Override
	public User loginUser(User u) {
		return userRepo.findUserByUsernameAndPassword(u.getUsername(), u.getPassword());
	}

	@Override
	public boolean isEmailUnique(User u) {
		User temp = userRepo.findUserByEmail(u.getEmail());
		if(temp == null) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> findAllUsersByRoleId(Integer roleId) {
		return userRepo.findAllByRoleId(roleId);
	}
}
