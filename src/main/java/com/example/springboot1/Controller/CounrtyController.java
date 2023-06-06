package com.example.springboot1.Controller;

import com.example.springboot1.Beans.Country;
import com.example.springboot1.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CounrtyController {

    @Autowired
    CountryService countryService;


    @GetMapping("/getcountries")
    public List getCountries()
    {
        return countryService.getAllCountries();
    }
    @GetMapping("/getcountries/{id}")
    public Country getCountryByID(@PathVariable(value = "id") int id)
    {
        return countryService.getCountryID(id);
    }
    @GetMapping("/getcountries/countryname")
    public Country getCountryByName(@RequestParam(value = "name") String name)
    {
        return countryService.getCountryByName(name);
    }
    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country)
    {
       return countryService.addCountry(country);
    }
    @PutMapping("/updatecountry")
    public Country updateCountry(@RequestBody Country country)
    {
        return countryService.addCountry(country);
    }
    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable(value = "id") int id )
    {
         return countryService.deleteCountry(id);
    }

}
