package webapplication.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Exit", urlPatterns = {"/Exit"})
public class Exit extends HttpServlet 
{

    public Exit() 
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.getSession().invalidate();
	request.getRequestDispatcher("exit.jsp").forward(request, response);
    }
}