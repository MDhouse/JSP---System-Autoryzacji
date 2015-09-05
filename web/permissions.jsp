<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Autoryzacji</title>
    </head>
    <body>
        <h1>Zmiana uprawnień</h1>
        
        <form action="Privlage" method="post">
            <table>
            <tr><td>Login:</td><td><input type="text" name="login"></td></tr>
            </table><br>
 	<input type="submit" value="Zmień uprawnienia">	
              
        <p><a href="list.jsp">Lista użytkowników</a></p>
        <p><br/><a href="profileOfCustomers.jsp">Powrót do profilu</a></p>
        </form>
        
        <h4><font color=red>
	<%
		if(request.getAttribute("Permissions") != null)
			out.println(request.getAttribute("Permissions"));
		if(request.getAttribute("DoesNotExist") != null)
			out.println(request.getAttribute("DoesNotExist"));
	%>
        </font></h4>
        
    </body>
</html>
