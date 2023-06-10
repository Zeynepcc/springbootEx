package com.example.springboot1.Controller;

import com.example.springboot1.Entity.Country;
import com.example.springboot1.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CounrtyController {

    @Autowired
    CountryService countryService;


    @GetMapping("/get")
    public List  getCountries()
    {
       return countryService.getAllCountries();
    }
    @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country>  getCountryByID(@PathVariable(value = "id") int id)
    {
        try
        {
            Country country = countryService.getCountryID(id);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getcountries/countryname")
    public ResponseEntity<Country> getCountryByName(@RequestParam(value = "name") String name)
    {
        try
        {
            Country country = countryService.getCountryByName(name);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country)
    {
        return countryService.addCountry(country);
    }
    @PutMapping("/updatecountry")
    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") int id , @RequestBody Country country)
    {
        try {

            Country existCountry = countryService.getCountryID(id);
            existCountry.setCountryname(country.getCountryname());
            existCountry.setCountryCapital(country.getCountryCapital());
            Country update_country = countryService.updateCountry(existCountry);
            return new ResponseEntity<Country>(update_country , HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
    @DeleteMapping("/deletecountry/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable(value = "id") int id )
    {
        Country country=null;
        try {
            country= countryService.getCountryID(id);
            countryService.deleteCountry(country);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(country, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(country, HttpStatus.NOT_FOUND);
    }

}
