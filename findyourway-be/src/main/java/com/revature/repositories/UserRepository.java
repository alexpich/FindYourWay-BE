package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findUserByEmail(String email);
	
	public User findUserByUsername(String username);
	
	public User findUserByFirstname(String firstname);
	
	public User findUserByLastname(String lastname);
	
	public User findUserByLocation(String location);
	
	public User findUserByUsernameAndPassword(String username, String password);

}
