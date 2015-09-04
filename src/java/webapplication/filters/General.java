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


//@WebFilter(filterName = "General", urlPatterns = {"/Registration", "/Exit","/exit.jsp","/listOfCustomers.jsp", "/profileOfCustomers.jsp"})
public class General implements Filter 
{
    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest req = (HttpServletRequest)request; 
	HttpServletResponse res =(HttpServletResponse)response;
        
        HttpSession session = req.getSession();
		
	if(session.getAttribute("login")!=null)
        {
            chain.doFilter(req, res);
        }
	else
        {
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() 
    {
        
    }    
}