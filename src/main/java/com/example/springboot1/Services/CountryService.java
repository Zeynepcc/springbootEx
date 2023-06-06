package com.example.springboot1.Services;

import com.example.springboot1.Beans.Country;
import com.example.springboot1.Controller.AddResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CountryService {

    static HashMap<Integer, Country> CountryIdMap;

    public CountryService()
    {
        CountryIdMap= new HashMap<Integer,Country>();
        Country turkeyCountry = new Country(1,"Turkey","Ankara");
        Country franceCoutry = new Country(2,"France","Paris");
        Country ukCountry = new Country(3,"UK","London");
        CountryIdMap.put(1,turkeyCountry);
        CountryIdMap.put(2,franceCoutry);
        CountryIdMap.put(3,ukCountry);

    }
    public List getAllCountries()
    {
        List countries = new ArrayList(CountryIdMap.values());
        return countries;
    }
    public Country getCountryID(int id)
    {
        Country country = CountryIdMap.get(id);
        return country;
    }
    public Country getCountryByName(String countryname)
    {
        Country country = null;
        for(int i:CountryIdMap.keySet())
        {
            if(CountryIdMap.get(i).getCountryname().equals(countryname))
            {
                country=CountryIdMap.get(i);
            }
        }
        return country;
    }
    public Country addCountry(Country country)
    {
        country.setId(getMaxID());
        CountryIdMap.put(country.getId(),country);
        return country;
    }
    public Country updateCountry(Country country)
    {
        if(country.getId()>0)
        {
            CountryIdMap.put(country.getId(),country);
        }
        return country;
    }
    public AddResponse deleteCountry(int id)
    {
        CountryIdMap.remove(id);
        AddResponse res= new AddResponse();
        res.setMsg("Country is deleted");
        res.setId(id);
        return res;

    }
    public static int getMaxID()
    {
        int max=0;
        for(int id:CountryIdMap.keySet())
        {
            if(max<=id)
            {
                max=id;
            }
        }
        return max+1;
    }
}
