<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hussain Lodge</title>
</head>
<body>
	<h2>Hussain Lodge Customer Details</h2>
	<hr>
	<table>
		<tr>
			<th>NAME</th>
			<th>CITY</th>
			<th>EMAIL</th>
			<th>MOBILE</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>

		<%
		ResultSet res = (ResultSet) request.getAttribute("registrations");
		while (res.next()) {
		%>
		<tr>
			<td><%=res.getString(1)%></td>
			<td><%=res.getString(2)%></td>
			<td><%=res.getString(3)%></td>
			<td><%=res.getString(4)%></td>
			<td><a href="delete?email=<%=res.getString(3)%>">delete</a></td>
			<td><a href ="update?email=<%=res.getString(3)%>&mobile=<%=res.getString(4)%>">update</a></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>