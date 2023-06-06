package com.example.springboot1.Beans;

public class Country {

    int id ;
    String countryname ;
    String countryCapital;

    public Country(int id , String name , String capital)
    {
        this.id=id;
        this.countryCapital=capital;
        this.countryname=name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

}
