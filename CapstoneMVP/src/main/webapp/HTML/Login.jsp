<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<h1>Login to Java Grading System</h1>
<body>
	<form action="/CapstoneMVP/LoginServlet" method="post">
		<label for="email">Email Address</label><br>
		<input type="email" name="email" id="email"><br>
		<label for="password">Password</label><br>
		<input type="password" name="password" id="password"><br>
		<input type="submit" value="Submit">
		
	</form>
</body>
</html>