package webapplication.servlets;

import domain.Adres;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.DummyDB;

@WebServlet(name = "DeleteTheAdres", urlPatterns = {"/DeleteTheAdres"})
public class DeleteTheAdres extends HttpServlet 
{

    public void init(ServletConfig config) throws ServletException 
    {
        ServletContext stc = config.getServletContext();        
        stc.setAttribute("adreses", new DummyDB());
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();
         
        Adres a = null;
        
        DummyDB db = (DummyDB) stc.getAttribute("adreses");        
        
        for(Adres adres :db.adreses)
        {
            if(adres.getCustomer().equals(request.getParameter("customer"))&& adres.getTypeOfAdres().equals(request.getParameter("typeofadres")))
            {
               a = adres;
            }
        }
        db.adreses.remove(a);
    }
}