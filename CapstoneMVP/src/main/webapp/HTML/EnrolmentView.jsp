<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javaObjects.Enrolment" %>
    <%@ page import="javaObjects.Student" %>
    <%@ page import="javaDAO.ApplicationDAO"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enrolments</title>
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
		<% ArrayList<Enrolment> enrolments = ApplicationDAO.getEnrolment(Integer.valueOf(request.getParameter("course")));
			for(Enrolment enrol: enrolments ){
		%>
			<li> <a href="/CapstoneMVP/AssignmentView?enrol=<%=enrol.getId()%>"><%=enrol.getStudent().getName()%></a> </li>
		
		<% } %>
	</ul>
	
</body>
</html>