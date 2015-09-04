package webapplication.servlets;

import domain.Customer;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.DummyDB;

@WebServlet(name = "ListOfCustomers", urlPatterns = {"/ListOfCustomers"})
public class ListOfCustomers extends HttpServlet 
{

    public ListOfCustomers() 
    {
        super();
    }
    public void init(ServletConfig config) throws ServletException 
    {
        ServletContext stc = config.getServletContext();        
        stc.setAttribute("customers", new DummyDB());
    }       

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();
        
        DummyDB db = (DummyDB)stc.getAttribute("customers");
        
       
        for(Customer c : db.customers)
        {
            System.out.println(c.getLogin()+" "+c.getPrivlage());
            request.getRequestDispatcher("listOfCustomers.jsp").forward(request, response);
            
        } 
    } 
}