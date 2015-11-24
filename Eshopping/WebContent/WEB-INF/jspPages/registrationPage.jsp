<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
	<form:form method="POST" action="/Eshopping/register">
		<table>
			<tr>
				<td><form:label path="firstname">firstname: </form:label></td>
				<td><form:input path="firstname"/></td>
			</tr>
			<tr>
				<td><form:label path="lastname">lastname: </form:label></td>
				<td><form:input path="lastname"/></td>
			</tr>
			<tr>
				<td><form:label path="address">address: </form:label></td>
				<td><form:input path="address"/></td>
			</tr>
			<tr>
				<td><form:label path="contact">contact: </form:label></td>
				<td><form:input path="contact"/></td>
			</tr>
			<tr>
				<td><form:label path="username">username: </form:label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">password: </form:label></td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="<<BACK" name="backButton"/></td>
				<td><input type="submit" value="Register" name="addCustomerButton"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>