<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Autoryzacji</title>
    </head>
    <body>
        <h1>Rejestracja</h1>
        
        <form action="Registration" method="post">
            <table>
            <tr><td>Login:</td><td><input type="text" name="login"></td></tr>
            <tr><td>Hasło:</td><td><input type="text" name="password"></td></tr>
            <tr><td>Potwierdż hasło:</td><td><input type="text" name="passwordAuthenticate"></td></tr>
            <tr><td>Email:</td><td><input type="text" name="email"></td></tr>
            </table><br>
 	<input type="submit" value="Zarejestruj">	
        <input type="reset" value="Wyczyść dane">
        </form>
        
        <h4><font color=red>
	<%
		if(request.getAttribute("fields") != null)
			out.println(request.getAttribute("fields"));
		if(request.getAttribute("password") != null)
			out.println(request.getAttribute("password"));
		if(request.getAttribute("login") != null)
			out.println(request.getAttribute("login"));
	%>
</font></h4>
    </body>
</html>
