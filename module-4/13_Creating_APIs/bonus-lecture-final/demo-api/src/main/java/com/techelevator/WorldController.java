package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @Autowired
    private CountryDao countryDao;

    @GetMapping("/greeting")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryDao.getAllCountries();
    }

}