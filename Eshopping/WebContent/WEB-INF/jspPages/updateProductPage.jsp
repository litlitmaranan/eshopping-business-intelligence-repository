<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<font color="red">${message}</font>
	</h3>
	<form:form method="GET" action="/Eshopping/editProducts">
		<table>
			<tbody>
				<tr>
					<td><form:label path="productbrand">product brand: </form:label></td>
					<td><form:select path="productbrand">
							<form:option value="" label="--SELECT CAR BRAND--" />
							<form:option value="iPhone" label="iPhone" />
							<form:option value="Samsung" label="Samsung" />
							<form:option value="Sony" label="Sony" />
							<form:option value="htc" label="htc" />
						</form:select></td>
				<tr>
					<td><form:label path="productname">product name: </form:label></td>
					<td><form:input path="productname"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="quantity">quantity: </form:label></td>
					<td><form:input path="quantity"></form:input></td>
				</tr>
				<tr>
				<tr>
					<td><form:label path="productprice">product price: </form:label></td>
					<td><form:input path="productprice"></form:input></td>
				</tr>
				<tr>
					<td><input value="<<back" name="previousPage" type="submit" /> 
					<input value="Edit Products" name="updateProducts" type="submit" /></td>
					<td><input type="text" id="productid" name="productid" value="${productid}" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>