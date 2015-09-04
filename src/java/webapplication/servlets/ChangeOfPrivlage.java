package webapplication.servlets;

import domain.Customer;
import domain.Privlage;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.DummyDB;

@WebServlet("/Privlage")
public class ChangeOfPrivlage extends HttpServlet 
{
    public ChangeOfPrivlage()
    {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();
        
        DummyDB db = (DummyDB)stc.getAttribute("customers");
        
        Customer c = null;
        
        for(Customer customer : db.customers)
        {
            if(customer.getLogin().equals(request.getParameter("login")))
                c = customer;
        }
        
        
        if(c != null)
	{
            if(c.getPrivlage().equals(Privlage.REGULAR))
            {
                c.setPrivlage(Privlage.PREMIUM);
                request.getRequestDispatcher("profileOfCustomers.jsp").forward(request, response);
            }
            else if(c.getPrivlage().equals(Privlage.PREMIUM))
            {
                c.setPrivlage(Privlage.REGULAR);
                request.getRequestDispatcher("profileOfCustomers.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("Permissions", "Użytkownik ma inne uprawnienia, nie można ich zmienić!!!");
                request.getRequestDispatcher("permissions.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("DoesNotExist", "Użytkownik o podanym loginie nie istnieje!!!");
            request.getRequestDispatcher("permissions.jsp").forward(request, response);
        }
                          
    }
}