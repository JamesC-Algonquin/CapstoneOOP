<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="javaObjects.Professor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="CSS/View.css" />
</head>
<body>
	<ul>
		<li class="nav"><a href="/CapstoneMVP/user/ProfessorServlet" class="active">Home</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/CourseView">Courses</a></li>
	</ul>
	<br>
	<%   
		Professor prof = (Professor) session.getAttribute("user");%>
	<h3>Welcome <%=prof.getName()%> </h3>

</body>
</html>