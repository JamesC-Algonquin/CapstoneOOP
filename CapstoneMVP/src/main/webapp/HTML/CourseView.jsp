<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javaObjects.Course" %>
    <%@ page import="javaObjects.Professor" %>
    <%@ page import="javaDAO.ApplicationDAO" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
<link rel="stylesheet" type="text/css" href="CSS/View.css" />
</head>
<body>	
	<ul>
		<li class="nav"><a href="/CapstoneMVP/ProfessorServlet">Home</a></li>
		<li class="nav"><a href="/CapstoneMVP/CourseView" class="active">Courses</a></li>
	</ul>
	<br>
	<br>
	<ul>
		<% ArrayList<Course> courses = ApplicationDAO.getCourses(Professor.getUser().getId()); 
			for(Course course: courses ){
		%>
			<li> <a href="/CapstoneMVP/EnrolmentView?course=<%=course.getId()%>"><%=course.getCourseName()%></a> </li>
		
		<% } %>
	</ul>

</body>
</html>