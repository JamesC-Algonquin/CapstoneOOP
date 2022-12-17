<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="javaObjects.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/CapstoneMVP/CSS/View.css" />
</head> 
<body>

<ul>
		<li class="nav"><a href="/CapstoneMVP/user/StudentServlet" class="active">Home</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/GradeView">Grades</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/EnrolView">Enrol</a></li>
		<li class="nav"><a href="/CapstoneMVP/LogoutServlet">Logout</a></li>
	</ul>
	<br>
	<br>
     <%Student student = (Student) session.getAttribute("user"); %>
	<h1>Welcome <%= student.getName() %></h1>
</body>
</html>