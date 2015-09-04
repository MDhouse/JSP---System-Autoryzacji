<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Autoryzacji</title>
    </head>
    <body>
        <h1>Logowanie</h1>
        
        <form action="Login" method="post">
            <table>
            <tr><td>Login:</td><td><input type="text" name="login"></td></tr>
            <tr><td>Hasło:</td><td><input type="text" name="password"></td></tr>
            </table><br>
 	<input type="submit" value="Zaloguj się">	
        <input type="reset" value="Wyczyść dane">
        
        <p><a href="registration.jsp">Rejestracja</a></p>
        </form>
        <%
            if(request.getAttribute("date") != null)
            {
                out.println(request.getAttribute("date"));
            }  
        %>       
    </body>
</html>
