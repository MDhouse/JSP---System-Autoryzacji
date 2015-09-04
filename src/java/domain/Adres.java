package domain;

public class Adres extends Entity
{
    private String typeOfAdres;
    private String province;
    private String city;
    private String postalCode;
    private String streetName;
    private String houseNumber;
    private String customer;

    public String getTypeOfAdres() 
    {
        return typeOfAdres;
    }

    public void setTypeOfAdres(String typeOfAdres) 
    {
        this.typeOfAdres = typeOfAdres;
    }

    public String getProvince() 
    {
        return province;
    }

    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getStreetName() 
    {
        return streetName;
    }

    public void setStreetName(String streetName) 
    {
        this.streetName = streetName;
    }

    public String getHouseNumber() 
    {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) 
    {
        this.houseNumber = houseNumber;
    }

    public String getCustomer() 
    {
        return customer;
    }

    public void setCustomer(String customer) 
    {
        this.customer = customer;
    }
}