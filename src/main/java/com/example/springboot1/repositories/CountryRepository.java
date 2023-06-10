package com.example.springboot1.repositories;

import com.example.springboot1.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>
{
}
