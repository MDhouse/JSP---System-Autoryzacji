package webapplication.servlets;

import domain.Customer;
import domain.CustomerBuilder;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.DummyDB;


@WebServlet(urlPatterns = {"/Registration"})
public class Registration extends HttpServlet 
{

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        ServletContext stc = config.getServletContext();        
        stc.setAttribute("customers", new DummyDB());
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();
         
        Customer c = null;
        
        DummyDB db = (DummyDB) stc.getAttribute("customers");
        
        CheckDate cd = new CheckDate(request);
        
        if(!cd.checkTheFields() || !cd.checkThePassword() || !cd.checkTheCustomer())
        {
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
        else
        {
            db.customers.add(new CustomerBuilder().build(request));
            request.getRequestDispatcher("success.jsp").forward(request, response);
        }
    }

}