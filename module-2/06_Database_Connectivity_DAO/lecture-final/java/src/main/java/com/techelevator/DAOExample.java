package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JdbcCityDAO;

public class DAOExample {

	public static void main(String[] args) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		
		
		CityDAO dao = new JdbcCityDAO(dataSource);
		
		City myCity = new City();
		myCity.setName("Zinzinnati");
		myCity.setDistrict("Ohio");
		myCity.setCountryCode("USA");
		myCity.setPopulation(10000);
		
		//dao.create(myCity);	
		//System.out.println(myCity.getId());
		
		myCity = dao.findCityById(4000);
		System.out.println(myCity.getName());
		
		List<City> cityList = dao.findCityByDistrict("Ohio");
		
		for (City c : cityList) {
			if (c.getName().equals("Zinzinnati")) {
				dao.delete(c.getId());
			}
		}

	}

}
