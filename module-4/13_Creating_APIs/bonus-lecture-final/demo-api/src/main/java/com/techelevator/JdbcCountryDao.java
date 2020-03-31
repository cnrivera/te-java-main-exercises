package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcCountryDao implements CountryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCountryDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Country> getAllCountries() {
        
        List<Country> countries = new ArrayList<>();

        String sql = "SELECT name, population FROM country;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Country c = new Country();
            c.setName(results.getString("name"));
            c.setPopulation(results.getInt("population"));
            countries.add(c);
        }
        return countries;
    }


}