<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="javaObjects.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head> 
<body>
     <%Student student = (Student) session.getAttribute("user"); %>
	<h1>Welcome <%= student.getName() %></h1>
</body>
</html>