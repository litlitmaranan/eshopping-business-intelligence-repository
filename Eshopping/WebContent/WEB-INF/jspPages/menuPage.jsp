<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
	<title>Eshopping</title>
</head>
<body>
	<h3>
		<font color="red">${message}</font>
	</h3>
	<table>
		<tbody>
			<form:form method="GET" action="/Eshopping/transactions">
				<tr>
					<td colspan="4">
						<input value="Add Product" name="addProduct" type="submit" />
						<input value="View Products" name="viewAllProduct" type="submit" />
					</td>
				</tr>
			</form:form>
		</tbody>
	</table>
</body>
</html>