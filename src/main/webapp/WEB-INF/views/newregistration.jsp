<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hussain Lodge</title>
</head>
<body>
	<h2>Hussain Lodge Registration Page....</h2>
	<hr>
	<form action="savereg" method="post">
		<pre>
       NAME<input type="text" name="name" />
       CITY<input type="text" name="city" />
       EMAIL<input type="text" name="email" />
       MOBILE<input type="text" name="mobile" />
       <input type="submit" value="save" />
       </pre>
	</form>
</body>
</html>