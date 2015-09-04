package domain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AdresBuilder implements IEntityBuilder<Adres>
{
    
    public Adres build(HttpServletRequest request) throws ServletException, IOException 
    {
        Adres a = new Adres();
        a.setTypeOfAdres(request.getParameter("typeOfAdres"));
        a.setProvince(request.getParameter("province"));
        a.setCity(request.getParameter("city"));
        a.setPostalCode(request.getParameter("postalCode"));
        a.setStreetName(request.getParameter("streetName"));
        a.setHouseNumber(request.getParameter("houseNumber"));
        a.setCustomer(request.getParameter("customer"));
        
        return a;
    }   
}