package webapplication.servlets;

import domain.Adres;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.DummyDB;

@WebServlet(name = "ShowTheAdres", urlPatterns = {"/ShowTheAdres"})
public class ShowTheAdres extends HttpServlet 
{
    public void init(ServletConfig config) throws ServletException 
    {
        ServletContext stc = config.getServletContext();        
        stc.setAttribute("adreses", new DummyDB());
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletContext stc = request.getServletContext();         
             
        DummyDB db = (DummyDB) stc.getAttribute("adreses");   
        
        PrintWriter out;
        
       
        out = response.getWriter();
        
        //tekst = request.getParameter("tekst");
        if (db.adreses != null)
            out.println("Z formularza otrzymałem: " + db.adreses);
        else
            out.println("Brak danych z formularza");
            
        for(Adres a : db.adreses)
        {
            if(a.getCustomer().equals(request.getSession().getAttribute("login")))
            {
                if(a.getTypeOfAdres().equals("checkIn"))
                {
                    request.getRequestDispatcher("profileOfCustomer.jsp").forward(request, response);
                    System.out.println("<p>Adres zameldowania:<br/>"+a.getProvince()+"<br/>"+a.getPostalCode()+" "+a.getCity()+"<br/>"+a.getStreetName()+" "+a.getHouseNumber()+"</p>");
                    System.out.println("<br/><a href=adres.jsp>Zmień</a>");
                    System.out.println("<a href=DeleteTheAdres?customer"+a.getCustomer()+"&typeofadres="+a.getTypeOfAdres()+">Usuń adres</a>");
                    
                }
                else if(a.getTypeOfAdres().equals("ofCorrespondence"))
                {
                    System.out.println("<p>Adres korenspodencyjny:<br/>"+a.getProvince()+"<br/>"+a.getPostalCode()+" "+a.getCity()+"<br/>"+a.getStreetName()+" "+a.getHouseNumber()+"</p>");
                    System.out.println("<br/><a href=adres.jsp>Zmień</a>");
                    System.out.println("<a href=DeleteTheAdres?customer"+a.getCustomer()+"&typeofadres="+a.getTypeOfAdres()+">Usuń adres</a>");
                    request.getRequestDispatcher("profileOfCustomer.jsp").forward(request, response);
                }
                else
                {
                    System.out.println("<p>Adres pracy:<br/>"+a.getProvince()+"<br/>"+a.getPostalCode()+" "+a.getCity()+"<br/>"+a.getStreetName()+" "+a.getHouseNumber()+"</p>");
                    System.out.println("<br/><a href=adres.jsp>Zmień</a>");
                    System.out.println("<a href=DeleteTheAdres?customer"+a.getCustomer()+"&typeofadres="+a.getTypeOfAdres()+">Usuń adres</a>");
                    request.getRequestDispatcher("profileOfCustomer.jsp").forward(request, response);
                }
            }
        }       
    }
}