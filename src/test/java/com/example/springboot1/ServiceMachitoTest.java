package com.example.springboot1;


import com.example.springboot1.Entity.Country;
import com.example.springboot1.Services.CountryService;
import com.example.springboot1.repositories.CountryRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ServiceMachitoTest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceMachitoTest {

    @Mock
    CountryRepository countryRep;

    @InjectMocks
    CountryService countryService;

    public List<Country> mycountries;
    @Test
    @Order(1)
    public void test_GetAllCountries()
    {
        List<Country> mycountries = new ArrayList<Country>();
        mycountries.add(new Country(1,"India","Delhi"));
        mycountries.add(new Country(2,"Turkey","Ankara"));
        when(countryRep.findAll()).thenReturn(mycountries);
        assertEquals(2, countryService.getAllCountries().size());
    }
    @Test
    @Order(2)
    public void test_getCountryID()
    {
        List<Country> mycountries = new ArrayList<Country>();
        mycountries.add(new Country(1,"India","Delhi"));
        mycountries.add(new Country(2,"Turkey","Ankara"));
        int countryID = 1;
        when(countryRep.findAll()).thenReturn(mycountries);
        assertEquals(countryID,countryService.getCountryID(countryID).getId());

    }

    @Test
    @Order(3)
    public void test_getCountryName()
    {
        List<Country> mycountries = new ArrayList<Country>();
        mycountries.add(new Country(1,"India","Delhi"));
        mycountries.add(new Country(2,"Turkey","Ankara"));
        String countryName = "India";

        when(countryRep.findAll()).thenReturn(mycountries);
        assertEquals(countryName,countryService.getCountryByName(countryName).getCountryname());

    }
    @Test
    @Order(4)
    public void test_addCountry()
    {
        Country country = new Country(3,"Yeni Gine", "Yok");
        when(countryRep.save(country)).thenReturn(country);
        assertEquals(country, countryService.addCountry(country));
    }

    @Test
    @Order(5)
    public void test_updateCountry()
    {
        Country country = new Country(3,"Yeni Gine", "Yok");
        when(countryRep.save(country)).thenReturn(country);
        assertEquals(country, countryService.updateCountry(country));
    }
    @Test
    @Order(6)
    public void test_deleteCountry()
    {
        Country country= new Country(3,"Yeni Gine", "Yok");
        countryService.deleteCountry(country);
        verify(countryRep,times(1)).delete(country); //times methodun kaç kez çağrılması gerektiğini niteler

    }

    //cucumber ile bağla users (individual corporate ad soyad) tutan bir table oluştur ci/cd


}
