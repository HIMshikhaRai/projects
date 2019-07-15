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

public class ViewUsersServlet extends HttpServlet {

	ServletContext context;
	RequestDispatcher disp;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		System.out.println("I am here");
		UserService userService = new UserServiceImpl();
		List<User> userlist = userService.listUsers();
		System.out.println("Size is:" + userlist.size());
		// set userlist object for accessing from the view by jsp file
		req.setAttribute("listOfUser", userlist);

		disp = context.getRequestDispatcher("/viewUsers.jsp");

		disp.forward(req, res);

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		doPost(req, res);
	}

}
