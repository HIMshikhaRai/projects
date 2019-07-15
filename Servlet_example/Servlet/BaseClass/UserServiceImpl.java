package com.soft.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soft.dbService.DatabaseConnection;
import com.soft.dbService.DatabaseConnectionImpl;

public class UserServiceImpl implements UserService {

	DatabaseConnection dbConnection = new DatabaseConnectionImpl();
	Statement stmt = dbConnection.doConnection();

	@Override
	public List<User> listUsers() {

		List<User> userList = new ArrayList<User>();
		String query = "SELECT * FROM users";

		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setStatus(rs.getInt("status"));

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public boolean addUser(User user) {

		String query = "Insert into users(fullname,username,password)"
				+ " values('" + user.getFullname() + "','" + user.getUsername()
				+ "','" + user.getPassword() + "');";

		try {
			stmt.execute(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User getUserDetails(int UserId) {

		User user = new User();
		String query = "Select * from users where id='" + UserId + "'";

		try {
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setStatus(rs.getInt("status"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void deleteUser(int userID) {
		String query = "Delete from users where id='" + userID + "'";
		try {
			stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean updateUser(User user) {
		String query = "Update users Set fullname='"+user.getFullname()+"','"+user.getUsername()+"','"+user.getEmail()+"','"+user.getStatus()+"'"
				+ " where id='"+user.getId()+"'";
		
		try {
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
