<%@page import="domain.Customer"%>
<%@page import="repository.DummyDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Autoryzacji</title>
    </head>
    <body>
        <h1>Lista użytkowników</h1>	
        <br/>
        <p><br/><a href="permissions.jsp">Powrót do zmiany uprawnień</a></p>
        <p><br/><a href="profileOfCustomers.jsp">Powrót do profilu</a></p>
        <%
        ServletContext stc = request.getServletContext();        
        DummyDB db = (DummyDB)stc.getAttribute("customers");
        for (Customer c : db.customers  )
        {
            out.println("<p><b>Typ konta: </b>"+ c.getLogin() +"<br/><b>Login: </b>"+ c.getPrivlage() + "<br/><b> Email: </b>"+ c.getEmail()+"</br/><p>");
        }
       %>
    </body>
</html>
