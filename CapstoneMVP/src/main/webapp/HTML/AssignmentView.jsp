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
		<form action="/CapstoneMVP/user/AssignmentView" method="POST">
			<label for="name">Assignment Name</label><br>
			<input type="text" id="name" name="name" required/><br>
			<label for="percent">Grade (Percent)</label><br>
			<input type="number" id="percent" name="percent" min="0" max="100" step="any" required/><br>
			<input type="submit" value="Submit" />
			<input type="hidden" value="<%=request.getParameter("enrol")%>" name="enrol" id="enrol" />		
		</form>
		
		<br><br><br>
		
		<ul>
		<% ArrayList<Grade> grades = ApplicationDAO.getGrades(Integer.valueOf(request.getParameter("enrol")));
			for(Grade grade: grades ){
		%>
			<li>Name: <%=grade.getAssignmentName() %> <br> Grade: <%=grade.getGradePercentage()%>
			 <a href="/CapstoneMVP/user/AssignmentEdit?action=edit&id=<%= grade.getId() %>&enrol=<%= request.getParameter("enrol") %>">Edit</a> 
			 <a href="/CapstoneMVP/user/AssignmentView?action=delete&id=<%= grade.getId() %>&enrol=<%= request.getParameter("enrol") %>">Delete</a></li>
		
		<% } %>
	</ul>
</body>
</html>