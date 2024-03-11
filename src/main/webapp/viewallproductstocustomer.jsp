<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.shoppingcart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Product> products = (List<Product>)request.getAttribute("productslist");
	%>
	<h1><a href="fetchitemsfromcart">view cart</a></h1>
	<table cellPadding="20px" border="1">
	<th>id</th>
	<th>brand</th>
	<th>model</th>
	<th>category</th>
	<th>price</th>
	<th>stock</th>
	<th>Add to cart</th>
	<%
	for(Product p:products){
	%>
	<tr>
		<td> <%= p.getId() %> </td>
		<td> <%= p.getBrand() %> </td>
		<td> <%= p.getModel() %> </td>
		<td> <%= p.getCategory() %> </td>
		<td> <%= p.getPrice() %> </td>
		<td> <%= p.getStock() %> </td>
		<td> <a href="additem?id=<%=p.getId()%>">add item</a> </td>
	</tr>
	<%} %>
	</table>
	
	
</body>
</html>