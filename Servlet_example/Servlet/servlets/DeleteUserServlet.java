package com.soft.UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.UserService.UserService;
import com.soft.UserService.UserServiceImpl;

public class DeleteUserServlet {

	ServletContext context;
	RequestDispatcher disp;

	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String userId = req.getParameter("id");
		int userID = Integer.parseInt(userId);
		UserService userService = new UserServiceImpl();
		userService.deleteUser(userID);
		disp = context.getRequestDispatcher("/deleteUser.jsp");
		disp.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		doPost(req, res);
	}

}
