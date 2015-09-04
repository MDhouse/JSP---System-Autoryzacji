package webapplication.servlets;

import domain.Adres;
import domain.AdresBuilder;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.DummyDB;

@WebServlet(name = "AddTheAdres", urlPatterns = {"/AddTheAdres"})
public class AddTheAdres extends HttpServlet 
{    
    public void init(ServletConfig config) throws ServletException 
    {
        ServletContext stc = config.getServletContext();        
        stc.setAttribute("adreses", new DummyDB());
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();
         
        Adres a = null;
        
        DummyDB db = (DummyDB) stc.getAttribute("adreses");
        
        CheckDate cd = new CheckDate(request);
                
        if(!cd.checkTheAdres() || !cd.checkTheProvince() || !cd.checkTypOfAdres())
        {
            request.getRequestDispatcher("adres.jsp").forward(request, response);
        }
        else
        {
            db.adreses.add(new AdresBuilder().build(request));
         
            request.getRequestDispatcher("profileOfCustomers.jsp").forward(request, response);
            System.out.println("Wynik:dodno adres");
        }
    }
} 
        