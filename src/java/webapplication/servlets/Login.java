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
import javax.servlet.http.HttpSession;
import repository.DummyDB;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    public Login() 
    {
        super();
    }
  
   public void init(ServletConfig config) throws ServletException 
    {
        ServletContext stc = config.getServletContext();        
        stc.setAttribute("customers", new DummyDB());
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();
        
        DummyDB db = (DummyDB)stc.getAttribute("customers");
        
        Customer c = null;
        
        for(Customer customer : db.customers)
        {
            if(customer.getLogin().equals(request.getParameter("login")))
            {
                c = customer;
            }
        }    
        
        if(c!=null && c.getPassword().equals(request.getParameter("password")))
        {
            HttpSession s = request.getSession();
            s.setAttribute("login", c.getLogin());
            s.setAttribute("password", c.getPassword());
            s.setAttribute("email", c.getEmail());
            s.setAttribute("privlage", c.getPrivlage());
            
            request.getRequestDispatcher("profileOfCustomers.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("date", "Login lub hasło są nie poprawne!!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}