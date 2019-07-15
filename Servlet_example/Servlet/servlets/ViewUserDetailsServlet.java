package com.soft.UserController;

import java.io.IOException;

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

public class ViewUserDetailsServlet extends HttpServlet {

	ServletContext context;
	RequestDispatcher disp;

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		int userId = Integer.parseInt(id);

		UserService userService = new UserServiceImpl();
		User userDet = userService.getUserDetails(userId);

		req.setAttribute("user_details", userDet);

		disp = context.getRequestDispatcher("/viewUserDetails.jsp");
		disp.forward(req, res);

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		doPost(req, res);
	}
}
