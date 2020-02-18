package com.techelevator;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class TransactionExample {

	public static void main(String[] args) throws SQLException {
		
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		
		Connection conn = dataSource.getConnection();		
		conn.setAutoCommit(false);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update("INSERT INTO actor (first_name, last_name) VALUES ('MATT', 'MARINARA');");
		
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT first_name, last_name FROM actor;");	
		while (results.next()) {
			System.out.format("%s %s\n", results.getString("first_name"), results.getString("last_name"));
		}
		
		conn.rollback();
		//conn.commit();
			
		System.out.println("***********************");
		
		results = jdbcTemplate.queryForRowSet("SELECT first_name, last_name FROM actor;");	
		while (results.next()) {
			System.out.format("%s %s\n", results.getString("first_name"), results.getString("last_name"));
		}
		
		dataSource.destroy();
	}

}
