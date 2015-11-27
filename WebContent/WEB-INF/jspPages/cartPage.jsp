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
				<h2><font color="blue">${customer}</font> <font color="red">${guest}</font></h2>
				<form:form method="GET" action="/Eshopping/backToMenuCustomer">
				 <input type="hidden" value="${customer}" name="customer" class="login login-submit"/> 
				 <input value="<<back" name="backPageCustomer" type="submit" class="login login-submit"/> 
		</form:form>

		
			<table>
		<tr>
			<td></td>
			<td>Product Brand</td>
			<td>Product Description</td>
			<td>Quantity</td>
			<td>Product Cost</td>
			<td></td>
		</tr>
		<tbody>
			<c:forEach var="product" items="${productlist}">
				<tr>
					<td><c:out value='${product.productid}'></c:out></td>
					<td><c:out value='${product.productbrand}'></c:out></td>
					<td><c:out value='${product.productname}'></c:out></td>
					<td><c:out value='${product.quantity}'></c:out></td>
					<td><c:out value='${product.productprice}'></c:out></td>
				<td><form:form method="GET" action="/Eshopping/accessToUser">
						<input type="hidden" id="productid" name="productid" value="${product.productid}" />
						<input type="hidden" id="productid" name="productbrand" value="${product.productbrand}" />
						<input type="hidden" id="productid" name="productname" value="${product.productname}" />
						<input type="hidden" id="productid" name="quantity" value="${product.quantity}" />
						<input type="hidden" id="productid" name="productprice" value="${product.productprice}" />
						<input type="hidden" id="customer" name="customer" value="${customer}" />
						<input type="submit" value="Buy Item" name="buyButton" class="login login-submit"/>
						<p>
						<input type="submit" value="Remove Item" name="deleteFromCart" class="login login-submit"/>

					</form:form></td>
			</c:forEach>
		</tbody>
	</table>

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