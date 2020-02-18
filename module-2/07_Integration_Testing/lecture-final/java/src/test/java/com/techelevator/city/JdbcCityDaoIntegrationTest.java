package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JdbcCityDaoIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";
	private static final long TEST_CITY_ID = 999;
	private static final String TEST_CITY_NAME = "Test City";
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JdbcCityDao dao;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update("TRUNCATE country CASCADE"); //remove existing data
		
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) " +
								  "VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', NULL, 'AF')";
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		
		dao = new JdbcCityDao(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void findCityById_returns_correct_city() {
		//Arrange		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update("INSERT INTO city (id, name, countrycode, district, population) " +
							"VALUES (?, ?, ?, 'Test District', 1)", TEST_CITY_ID, TEST_CITY_NAME, TEST_COUNTRY);
		
		//Act
		City foundCity = dao.findCityById(TEST_CITY_ID);
		
		//Assert
		assertNotNull(foundCity);
		assertEquals(TEST_CITY_ID, foundCity.getId().longValue());
		assertEquals(TEST_CITY_NAME, foundCity.getName());
	}
	
	private City createTestCity() {
		City newCity = new City();
		newCity.setName(TEST_CITY_NAME);
		newCity.setDistrict("Test District");
		newCity.setCountryCode(TEST_COUNTRY);
		newCity.setPopulation(1);
		
		return newCity;
	}
	
	@Test
	public void create_new_city_and_read_it_back() {
		//Arrange
		City newCity = createTestCity();
		//Act
		dao.create(newCity);
		City foundCity = dao.findCityById(newCity.getId());
		//Assert
		assertNotNull(foundCity);
		assertEquals(newCity.getName(), foundCity.getName());
		//Check remaining fields.
	}
	
	@Test
	public void finds_multiple_cities_by_country_code() {
		//Arrange
		for (int i = 0; i < 100; i++) {
			City newCity = createTestCity();
			newCity.setName(newCity.getName() + i);
			dao.create(newCity);
		}
		
		//Act
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		//Assert
		assertNotNull(results);
		assertEquals(100, results.size());
	}
	
	@Test
	public void update_cant_remove_city_name() {
		City c = createTestCity();
		dao.create(c);
		c.setName(null);
		
		boolean result = dao.update(c);
		
		assertFalse(result);
	}
	
	@Test
	public void delete_removes_city() {
		City c = createTestCity();
		dao.create(c);
		
		dao.delete(c.getId());
		
		City foundCity = dao.findCityById(c.getId());
		assertNull(foundCity);
	}
	
}
