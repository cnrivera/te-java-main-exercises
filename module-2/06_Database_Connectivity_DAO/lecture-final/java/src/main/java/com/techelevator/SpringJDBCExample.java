package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword(System.getenv("DB_PASSWORD"));
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
		
		String filmsUnder90min = "SELECT title, length FROM film WHERE length < 90;";
		
		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(filmsUnder90min);
		
		while (results.next()) {
			String title = results.getString("title");
			int length = results.getInt("length");
			
			//System.out.format("%25s %10d\n", title, length);
		}
		
		String firstName = "ROCK";
		String lastName = "DUKAKIS";
		
		String filmsStarringActor = "SELECT title AS film_name " +
									"FROM film " +
									"JOIN film_actor ON film.film_id = film_actor.film_id " +
									"JOIN actor ON film_actor.actor_id = actor.actor_id " +
									"WHERE actor.first_name = ? AND actor.last_name = ?;";
		
		results = dvdstoreJdbcTemplate.queryForRowSet(filmsStarringActor, firstName, lastName);
		
		while (results.next()) {
			//System.out.println(results.getString("film_name"));
		}
		
		String sqlCreateActor = "INSERT INTO actor (first_name, last_name) VALUES (?, ?);";
		
		firstName = "TRENT";
		lastName = "BARBECUE";
		
		//int rowCount = dvdstoreJdbcTemplate.update(sqlCreateActor, firstName, lastName);
		//System.out.println(rowCount);
		
		String sqlCreateReturningId = "INSERT INTO actor (first_name, last_name) VALUES (?, ?) RETURNING actor_id;";
		
		results = dvdstoreJdbcTemplate.queryForRowSet(sqlCreateReturningId, firstName, lastName);
		
		results.next();
		System.out.println(results.getInt("actor_id"));
		
		String sqlDeleteActor = "DELETE FROM actor WHERE first_name = ? AND last_name = ?;";
		int rowCount = dvdstoreJdbcTemplate.update(sqlDeleteActor, firstName, lastName);
		System.out.println(rowCount);
		
	}
}
