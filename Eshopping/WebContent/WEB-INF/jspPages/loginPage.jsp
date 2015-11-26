
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Shopping System</title>
</head>
<h3><font color="red">${errorMessage}</font></h3>
<h3><font color="blue">${successMessage}</font></h3>
</head>								
<body>
	<form:form method="POST" action="/Eshopping/login">
		<table>
			<tr>
				<td><form:label path="username">username: </form:label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">password: </form:label></td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" name="loginButton"/></td>
				<td><input type="submit" value="Register" name="registerButton"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>