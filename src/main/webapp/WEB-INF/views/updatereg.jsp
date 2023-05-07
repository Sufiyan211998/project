<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hussain Lodge</title>
</head>
<body>
      <h2>Hussain Lodge Update Registration Page....</h2>
      <hr>
      <form action="update" method="post">
      <pre>
      EMAIL<input type ="text" name="email"value="<%=request.getAttribute("email") %>"/>
      MOBILE<input type ="text" name="mobile"value="<%=request.getAttribute("mobile") %>"/>
      <input type ="submit" value="update"/>
      </pre>
      </form>
</body>
</html>