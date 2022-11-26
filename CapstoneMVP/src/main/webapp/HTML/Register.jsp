<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="/CapstoneMVP/CSS/style.css" />
    </head>
    <body>
        <div class="container">
            <h1>Register with Java Grading System</h1>
            <form action="/CapstoneMVP/Register" method="post">
            	<input type="text" placeholder="Name" class="field" id="name" name="name" required/>
                <input type="email" placeholder="Email Address" class="field" id="email" name="email" required/>
                <input type="password" placeholder="Password" class="field" id="password" name="password" required/>
                <input type="radio" class="field" id="prof" value="prof" name="type" required/><label for="prof">Professor</label>
                <input type="radio" class="field" id="student" value="student" name="type" required/><label for="student">Student</label>
                <input type="submit" value="Register" class="btn" />
            </form>
        </div>
        <br>
        Have an Account? <a href="/CapstoneMVP/LoginServlet">Log In Here</a>
        
    </body>
</html>