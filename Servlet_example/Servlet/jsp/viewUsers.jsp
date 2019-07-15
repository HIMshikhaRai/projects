<%@page import="com.soft.UserService.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>view all users</h1>
	<%
		List<User> userList = (List<User>) request.getAttribute("listOfUser");
	%>
	<h3>
		Total numbers of users:
		<%=userList.size() %>
	</h3>
	
	<a href="add-user.jsp">Add new User</a>

	<table border="1">
		<tr>
			<td>s.n.</td>
			<td>FUll Name</td>
			<td>Username</td>
			<td>Email</td>
			<td>status</td>
 
			<td colspan="2">Action</td>

		</tr>
		<% for(int a=0;a<userList.size();a++){ 
		   User user = (User)userList.get(a); 
		%>
		<tr>
			<td><%= user.getId() %></td>
			<td><%= user.getFullname() %></td>
			<td><%= user.getUsername() %></td>
			<td><%= user.getEmail() %></td>
			<td><%= (user.getStatus()==0)? "Disabled" : "Enabled"  %></td>
			
			<td>
				<a href="viewUserDetails?id=<%= user.getId()%>">View</a>
				<a href="?id=<%= user.getId()%>">Delete</a>
			</td>
			
		</tr>
		<%} %>
	</table>

</body>
</html>