<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Shopping System</title>
</head>
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
		<div id="main">
			<div class="right">
				<div class="nav">
				<h2>About Us</h2>
				<div class="text">
			Hi, My name is Leah Maranan and this is my final project in j2ee. This is a dummy online shopping system that uses j2ee with spring framework.
				</div>
				<h2>Products</h2>
					<ul>
						<li>Iphone</li>
						<li>Samsung</li>
						<li>Sony</li>
						<li>Nokia</li>
						
					</ul>
				</div>
			</div>
			
			<div class="left">
				<div class="login-card">
				    <h1>Add new Item</h1><br>
				    <font color="blue">${successMessage}</font> <font color="red">${errorMessage}</font>
				    
				    <form:form method="GET" action="/Eshopping/addNewProducts">
				    	<form:select path="productbrand">
							<form:option value="" label="--SELECT CAR BRAND--" />
							<form:option value="iPhone" label="iPhone" />
							<form:option value="Samsung" label="Samsung" />
							<form:option value="Sony" label="Sony" />
							<form:option value="htc" label="htc" />
						</form:select> <p>
						<form:input path="productname" placeholder="name of item"></form:input>
				    	quantity: <form:input path="quantity" placeholder="how many"></form:input>
				    	price: <form:input path="productprice" placeholder="item price"></form:input>
				    	
					    	<input type="hidden" value="admin" name="admin" class="login login-submit"/>
					    	<input value="Add Products" name="addProducts" type="submit" class="login login-submit"/>
					    	<input value="<<back" name="previousPage" type="submit" class="login login-submit"/>
					    	
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
	</div>
</body>
</html>