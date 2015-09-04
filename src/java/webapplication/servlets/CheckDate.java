package webapplication.servlets;

import domain.Customer;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import repository.DummyDB;

public class CheckDate 
{
   private final HttpServletRequest request;

    public CheckDate(HttpServletRequest request) 
    {
        this.request = request;
    }
    
    public boolean checkTheFields()
    {
        if(request.getParameter("login").isEmpty() || request.getParameter("password").isEmpty() || request.getParameter("passwordAuthenticate").isEmpty() || request.getParameter("email").isEmpty())
        {
            request.setAttribute("fields", "Proszę wypełnić wszystkie pola!!!");
            return false; 
        }
        else
        {
            return true;
        }   
    }
    
    public boolean checkThePassword()
    {
        if(request.getParameter("password").equals(request.getParameter("passwordAuthenticate")))
        {
            return true;
        }
        else
        {
            request.setAttribute("password", "Proszę podać prawidłowe hasło!!!");
            return false;            
        }
    }
    
    public boolean checkTheCustomer()
    {
        ServletContext stc = request.getServletContext();
	DummyDB db = (DummyDB)stc.getAttribute("customers");
        
        for(Customer c : db.customers)
        {
            if(request.getParameter("login").equals(c.getLogin()))
            {
                request.setAttribute("login", "Proszę podać inny Login");
                return false;
            }
            else 
            {
                return true;
            }         
        }
	
        return true;		
    }
    
    public boolean checkTheAdres()
    {
        if(request.getParameter("city").isEmpty() || request.getParameter("postalcode").isEmpty() ||  request.getParameter("street").isEmpty() ||  request.getParameter("housenumber").isEmpty())
        {
            request.setAttribute("adres", "Proszę wypełnić wszystkie pola!!!");
            return false; 
        }
        else
        {
            return true;
        }  
    }
    
    public boolean checkTheProvince()
    {
        if(request.getParameter("province").equals(request.getParameter("default")))
        {
                request.setAttribute("province", "Proszę wybrać województwo!!!");
                return false;
        }
        else 
        {
            return true;
        } 
    }
    
    public boolean checkTypOfAdres()
    {
        if(request.getParameter("typeofadres").equals(request.getParameter("default")))
        {
                request.setAttribute("type", "Proszę wybrać typ adresu!!!");
                return false;
        }
        else 
        {
            return true;
        } 
    
    }
}