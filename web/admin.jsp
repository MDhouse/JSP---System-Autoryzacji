<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Autoryzacji</title>
    </head>
    <body>
        <h1>Strona użytkownika</h1>
        
        <h3>WItaj <%=request.getSession().getAttribute("login")%></h3>
        Nazwa użytkownika: <%=session.getAttribute("login")%><br/>
        Email: <%=session.getAttribute("email")%><br/>
        Status: <%=session.getAttribute("privlage")%><br/>
             
        <p><a href="permissions.jsp">Zmiana uprawnień</a></p>
        
        <p><a href="premium.jsp">Strona premium</a></p>
        
        <p><a href="admin.jsp">Panel administracyjny</a></p>
        
        <p><a href="Exit">Wyloguj mnie</a></p>
                
    </body>
</html>
