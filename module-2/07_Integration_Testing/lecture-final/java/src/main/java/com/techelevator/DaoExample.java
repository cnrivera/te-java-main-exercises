package com.techelevator;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDao;
import com.techelevator.city.JdbcCityDao;

public class DaoExample {

	public static void main(String[] args) throws SQLException {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		
		CityDao dao = new JdbcCityDao(dataSource);
		
		List<City> myCities = dao.findCityByDistrict("Kentucky");
		
		for (City c : myCities) {
			System.out.println(c);
		}
		
		City currentCity = dao.findCityById(3858);
		currentCity.setName(null);
		if (dao.update(currentCity)) {
			System.out.println("It worked.");
		} else {
			System.out.println("Update failed.");
		}
		
		

	}

}
