package domain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class CustomerBuilder implements IEntityBuilder<Customer>
{
    public Customer build(HttpServletRequest request) throws ServletException, IOException 
    {
        
        Customer c = new Customer();
        c.setLogin(request.getParameter("login"));
        c.setPassword(request.getParameter("password"));
        c.setEmail(request.getParameter("email"));
        c.setPrivlage(Privlage.REGULAR);
        
        
        
        if(request.getParameter("login").equals("admin") && request.getParameter("password").equals("admin"))
        {
            c.setPrivlage(Privlage.ADMIN);
        }
	else
        {
            c.setPrivlage(Privlage.REGULAR);
        }
	
        return c;
    }
}