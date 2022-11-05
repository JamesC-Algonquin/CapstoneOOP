<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="CSS/style.css" />
    </head>
    <body>
        <div class="container">
            <h1>Login to Java Grading System</h1>
            <form action="/CapstoneMVP/LoginServlet" method="post">
                <input type="email" placeholder="Email Address" class="field" id="email" name="email"/>
                <input type="password" placeholder="Password" class="field" id="password" name="password"/>
                <input type="submit" value="Log In" class="btn" />
            </form>
        </div>
    </body>
</html>