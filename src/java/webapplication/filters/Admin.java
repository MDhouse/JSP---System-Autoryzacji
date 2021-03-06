package webapplication.filters;

import domain.Customer;
import domain.Privlage;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.DummyDB;

@WebFilter(filterName = "Admin", urlPatterns = {"/Privlage", "/permissions.jsp", "/list.jsp", "/admin.jsp"})
public class Admin implements Filter  
{
    FilterConfig filterConfig = null;
    
   

    public void init(FilterConfig filterConfig) throws ServletException 
    {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest req = (HttpServletRequest)request; 
	HttpServletResponse res =(HttpServletResponse)response;
        
        HttpSession session = req.getSession();
        
        ServletContext stc = req.getServletContext();
        
        DummyDB db = (DummyDB)stc.getAttribute("customers");
        
       Customer c = null;
        
        for(Customer customer : db.customers)
        {
            if(customer.getLogin().equals(session.getAttribute("login")))
                 c = customer;
        }
        
        if(c==null || c.getPrivlage()!=Privlage.ADMIN)
        {            
            req.getRequestDispatcher("lackOfAccess.jsp").forward(req, res);
        }
        else
        {
            chain.doFilter(req, res);
        }
    }

    public void destroy() 
    {
        
    }

}