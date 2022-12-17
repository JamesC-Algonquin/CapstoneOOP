<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="javaObjects.Student"%>
     <%@ page import="javaObjects.Grade" %>
    <%@ page import="javaDAO.ApplicationDAO" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
<link rel="stylesheet" type="text/css" href="/CapstoneMVP/CSS/View.css" />
</head> 
<body>

<ul>
		<li class="nav"><a href="/CapstoneMVP/user/StudentServlet">Home</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/GradeView" class="active">Grades</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/EnrolView">Enrol</a></li>
		<li class="nav"><a href="/CapstoneMVP/LogoutServlet">Logout</a></li>
	</ul>
	<br>
	<br>
	<ul>
     <%ArrayList<Grade> grades = ApplicationDAO.getGrades(Integer.valueOf(request.getParameter("course")));
     for(Grade grade: grades ){ %>
     
			<li>Name: <%=grade.getAssignmentName() %> <br> Grade: <%=grade.getGradePercentage()%>  </li>
		
		<% } %>
	</ul>

</body>
</html>