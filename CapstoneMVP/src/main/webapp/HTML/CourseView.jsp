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
<link rel="stylesheet" type="text/css" href="/CapstoneMVP/CSS/View.css" />
</head>
<body>	
	<ul>
		<li class="nav"><a href="/CapstoneMVP/user/ProfessorServlet">Home</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/CourseView" class="active">Courses</a></li>
		<li class="nav"><a href="/CapstoneMVP/LogoutServlet">Logout</a></li>
	</ul>
	<br>
	<br>
		<form action="/CapstoneMVP/user/CourseView" method="POST">
			<label for="name">Course Name</label><br>
			<input type="text" id="name" name="name" required/><br>
			<input type="submit" value="Submit" />		
		</form>
		
		<br>
	
	<br>
	<ul>
		<% 	Professor prof = (Professor) session.getAttribute("user");
			
			ArrayList<Course> courses = ApplicationDAO.getCourses(prof.getId()); 
			for(Course course: courses ){
		%>
			<li> <a href="/CapstoneMVP/user/EnrolmentView?course=<%=course.getId()%>"><%=course.getCourseName()%></a> </li>
		
		<% } %>
	</ul>

</body>
</html>