package com.example.springboot1.Services;

import com.example.springboot1.Entity.Country;
import com.example.springboot1.Controller.AddResponse;
import com.example.springboot1.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CountryService {

    @Autowired
    CountryRepository countryrep;


    public List<Country> getAllCountries()
    {
        return countryrep.findAll();
    }
    public Country getCountryID(int id)
    {
        return countryrep.findById(id).get();
    }
    public Country getCountryByName(String countryname)
    {
        List<Country> countries=  countryrep.findAll();
        Country country = null;
        for (Country con:countries)
        {
            if(con.getCountryname().equalsIgnoreCase(countryname))
                country=con;
        }
        return country;
    }
    public Country addCountry(Country country)
    {
        country.setId(getMaxID());
        countryrep.save(country);
        return country;
    }
    public Country updateCountry(Country country)
    {
        countryrep.save(country);
        return country;
    }
    public AddResponse deleteCountry(int id)
    {
        countryrep.deleteById(id);
        AddResponse res = new AddResponse();
        res.setMsg("Country Deleted");
        res.setId(id);
        return res;
    }
    public int getMaxID()
    {
        return countryrep.findAll().size()+1;
    }
}
