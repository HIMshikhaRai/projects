package com.soft.UserService;

import java.util.List;

public interface UserService {
	
	//list all users
	public List<User> listUsers();
	
	//add a new user
	public boolean addUser(User user);
	
	//get user details from the database
	public User getUserDetails(int UserId);
	
	//delete user 
	public void deleteUser(int userID);
	
	//update user
	public boolean updateUser(User user);
	
	
	

}
