package webapplication.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LoginOrRegistration", urlPatterns = {"/login.jsp", "/registration.jsp", "/Registration", "/Login"})
public class LoginOrRegistration implements Filter 
{
    FilterConfig filterConfig = null;

    public LoginOrRegistration() 
    {
        
    }
       
    public void init(FilterConfig filterConfig) throws ServletException 
    {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest req = (HttpServletRequest)request; 
	HttpServletResponse res =(HttpServletResponse)response;
        
        HttpSession session = req.getSession();
		
	if(session.getAttribute("login")!=null)
        {   
            req.getRequestDispatcher("profileOfCustomers.jsp").forward(req, res);
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