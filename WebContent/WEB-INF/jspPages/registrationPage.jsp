<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/loginPage.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Shopping System</title>
<body>
	
	<div class="content">
		<div id="top">
			<div class="topright">
			 	by Leah D. Maranan			
			</div>
		</div>
		<div id="header">
			<div class="headings">
				<h1>Shop-Online</h1>
				<h2>we bring shopping into your home</h2>
			</div>
		</div>
			<div id="menu">
			  	<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Contact Us</a></li>
      			</ul>
			</div>	
			
			<div class="left">
				<div class="login-card">
				    <h1>Log-in</h1><br>
				    <font color="blue">${successMessage}</font> <font color="red">${errorMessage}</font>
				    <form:form method="POST" action="/Eshopping/register">
				    	<form:input path="firstname" placeholder="firstname" />
				    	<form:input path="lastname" placeholder="lastname" />
				    	<form:input path="address" placeholder="address" />
				    	<form:input path="contact" placeholder="contact" />
				    	<form:input path="username" placeholder="username" />
				    	<form:password path="password" placeholder="password" />
					    	<input type="submit" value="Register" name="addCustomerButton" class="login login-submit" />
					    	<input type="submit" value="Back to Login Page" name="backButton" class="login login-submit" />
				  </form:form>
				</div>
			</div>
			
		</div>
		
		<div id="footer">
			<div class="info">
				&copy; Shop-Online 2015<br />
				by leah maranan
			</div>
		</div>
</body>
</html>