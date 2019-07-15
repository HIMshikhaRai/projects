<%@page import="com.soft.UserService.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	i am in viewUserDetails.jsp
	<%
	User user = (User) request.getAttribute("user_details");
%>
	<table border="1">
		<tr>
			<td>sn</td>
			<td><%=user.getId()%></td>
		</tr>
		<tr>
			<td>Full Name</td>
			<td><%=user.getFullname()%></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><%=user.getUsername()%></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=user.getEmail()%></td>
		</tr>
		<tr>
			<td>status</td>
			<td><%=user.getStatus()%></td>
		</tr>
	</table>
</body>
</html>