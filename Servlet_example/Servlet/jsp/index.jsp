<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CanteenManagement</title>
</head>
<body>
<table  border="0" align="center">
		<tr>
        	<td><font size="+3" color="#FF8040" face="Comic Sans MS, cursive">kHaja gHar</font></td>
        </tr>
	</table>
    <br/><br/>
    <form action="doLogin" method="post" name="loginFrm">
    <table bgcolor="#DDDDDD"  width="30%" height="250px" align="center">	
    	<tr>
        <td align="center" >
        	<p align="center"><font size="+2">Sign In To Continue</font></p><br/>
        	<input type="text" value="username" name="username" id="usercode" border="0.1" maxlength="50" style=" height:30Px;  width:80%; font-size:larger; "/><br/>
            <input type="password" value="password" name="password" id="password" border="0.1" maxlength="30" style="height:30Px;width:80%; font-size:larger"/><br/><br/>
            <input type="submit" value="Sign in" name="login"  id="login" style="width:82%; background-color:#1278F5;height:40Px"/>
        </td>
        </tr>
    </table>
    </form>
</body>
</html>