package com.soft.LoginService;

import com.soft.UserService.User;

public interface UserLoginInterface {
	
	//validates user to the system
	public boolean isValidUser(User user);
}
