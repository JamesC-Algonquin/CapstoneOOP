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
<link rel="stylesheet" type="text/css" href="CSS/View.css" />
</head>
<body>
<ul>
		<li class="nav"><a href="/CapstoneMVP/user/ProfessorServlet">Home</a></li>
		<li class="nav"><a href="/CapstoneMVP/user/CourseView" class="active">Courses</a></li>
	</ul>
	<br>
	<br>
		<form action="/CapstoneMVP/AssignmentView" method="POST">
			<label for="name">Assignment Name</label><br>
			<input type="text" id="name" name="name" /><br>
			<label for="percent">Grade (Percent)</label><br>
			<input type="number" id="percent" name="percent"/><br>
			<input type="submit" value="Submit" />
			<input type="hidden" value="<%=request.getParameter("enrol")%>" name="enrol" id="enrol" />		
		</form>
		
		<br><br><br>
		
		<ul>
		<% ArrayList<Grade> grades = ApplicationDAO.getGrades(Integer.valueOf(request.getParameter("enrol")));
			for(Grade grade: grades ){
		%>
			<li>Name: <%=grade.getAssignmentName() %> <br> Grade: <%=grade.getGradePercentage()%> </li>
		
		<% } %>
	</ul>
</body>
</html>