package com.soft.UserController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.UserService.User;
import com.soft.UserService.UserService;
import com.soft.UserService.UserServiceImpl;

public class AddUserServlet extends HttpServlet {

	ServletContext context;
	RequestDispatcher disp;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		User user = new User();
		
		String fullName = req.getParameter("fullname");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		user.setFullname(fullName);
		user.setUsername(userName);
		user.setPassword(password);
		
		UserService userService = new UserServiceImpl();
		boolean isValid = userService.addUser(user);
		
		List<User>  userList = userService.listUsers();
		req.setAttribute("listOfUser", userList);
		
		if(isValid){
			disp = context.getRequestDispatcher("/viewUsers.jsp");
		}
		else{
			disp = context.getRequestDispatcher("/add-user.jsp");
		}
		
		disp.forward(req, res);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		doPost(req, res);
	}
}
