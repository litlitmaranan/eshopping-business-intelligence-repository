<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Shopping System</title>
</head>
<!-- <h3><font color="blue">Welcome ${username}</font></h3>
<h3><font color="red">${errorMessage}</font></h3> -->
<body>
	<!-- <table>
		<tr>
			<td><form:form method="POST"
					action="/Eshopping/EditUserInformation">
					<input type="hidden" id="username" name="username" value="${username}" />
					<input type="submit" id="Edit" name="toUpdate"
						value="Edit Your Information" />
					<input type="submit" id="Remove" name="toDelete"
						value="Delete Account" />
				</form:form></td>
		</tr>
	</table> -->
	view all products and you can put to cart and view details
	<form:form method="POST" action="/Eshopping/shopping">
		<table>
			<tr>
				<td>Product Brand</td>
				<td>Product Description</td>
				<td>Quantity</td>
				<td>Product Cost</td>
			</tr>
			<tbody>
				<c:forEach var="product" items="${productlist}">
					<tr>
						<td><c:out value='${product.productid}'></c:out></td>
						<td><c:out value='${product.productbrand}'></c:out></td>
						<td><c:out value='${product.productname}'></c:out></td>
						<td><c:out value='${product.quantity}'></c:out></td>
						<td><c:out value='${product.productprice}'></c:out></td>
					</tr>
					<td><form:form method="GET" action="/Eshopping/adminRights">
							<input type="text" id="productid" name="productid"
								value="${product.productid}" />
							<input type="submit" value="Edit" name="updateProduct" />
							<input type="text" id="productid" name="productid"
								value="${product.productid}" />
							<input type="submit" value="Remove" name="deleteProduct" />
						</form:form></td>
				</c:forEach>
			</tbody>
		</table>
		<td><input value="<<back" name="backPage" type="submit" /></td>
	</form:form>
</body>
</html>