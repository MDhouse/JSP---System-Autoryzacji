package webapplication.servlets;

import domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext stc = request.getServletContext();
        
        DummyDB db = (DummyDB)stc.getAttribute("customers");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();
        
        DummyDB db = (DummyDB)stc.getAttribute("customers");
        
         request.getRequestDispatcher("list.jsp").forward(request, response);	
            

        for (Customer c : db.customers  ){
	  out.println("<p><b>Typ konta: </b>" + c.getLogin() +
			  "<br><b>Username: </b>" + c.getPrivlage() +
			  "<br><b> Email: </b></br></br><p>");
        
    }
              
    
        
    } 
}