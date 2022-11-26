<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javaObjects.Enrolment" %>
    <%@ page import="javaObjects.Grade" %>
    <%@ page import="javaDAO.ApplicationDAO"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignments</title>
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
		<%	int id = Integer.valueOf(request.getParameter("id"));
			Grade grade = ApplicationDAO.getGrade(id); %>
			
			
		<form action="/CapstoneMVP/user/AssignmentEdit" method="POST">
			<label for="name">Assignment Name</label><br>
			<input type="text" id="name" name="name" value=<%= grade.getAssignmentName() %> required/><br>
			<label for="percent">Grade (Percent)</label><br>
			<input type="number" id="percent" name="percent" min="0" max="100" value=<%=grade.getGradePercentage()%> required/><br>
			<input type="submit" value="Submit" />
			<input type="hidden" value="<%=request.getParameter("enrol")%>" name="enrol" id="enrol" />
			<input type="hidden" value="<%=request.getParameter("id")%>" name="id" id="id" />
		</form>

</body>
</html>