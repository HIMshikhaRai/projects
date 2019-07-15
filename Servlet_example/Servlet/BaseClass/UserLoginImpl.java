package com.soft.LoginService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.soft.UserService.User;
import com.soft.dbService.DatabaseConnection;
import com.soft.dbService.DatabaseConnectionImpl;

public class UserLoginImpl implements UserLoginInterface {

	@Override
	public boolean isValidUser(User user) {
		
		DatabaseConnection dbConnection = new DatabaseConnectionImpl();
		Statement stmt = dbConnection.doConnection();
		
		String query = "SELECT * FROM users WHERE username='"+user.getUsername()+"' AND password ='"+user.getPassword()+"'";
		
		try {
			ResultSet result = stmt.executeQuery(query);
			if(result.next()){
				return true;
			}
			else{
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
