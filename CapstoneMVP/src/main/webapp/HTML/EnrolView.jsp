<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="javaObjects.Student"%>
     <%@ page import="javaObjects.Course" %>
    <%@ page import="javaDAO.ApplicationDAO" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enrol in a Course</title>
<link rel="stylesheet" type="text/css" href="/CapstoneMVP/CSS/View.css" />
</head> 
<body>

<ul>
		<li class="nav"><a href="/CapstoneMVP/user/StudentServlet">Home</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/GradeView">Grades</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/EnrolView" class="active">Enrol</a></li>
		<li class="nav"><a href="/CapstoneMVP/LogoutServlet">Logout</a></li>
	</ul>
	<br>
	<br>
	<ul>
     <% Student student = (Student) session.getAttribute("user");
     ArrayList<Course> courses = ApplicationDAO.getNewCourses(student.getId());
     for(Course course: courses ){%>
     
     <li>Course: <%=course.getCourseName()%> <a href="/CapstoneMVP/user/EnrolView?course=<%=course.getId()%>">Enrol</a> </li>
		
		<% } %>
	</ul>

</body>
</html>