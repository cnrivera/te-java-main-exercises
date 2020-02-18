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
		
		Connection conn = dataSource.getConnection();		
		conn.setAutoCommit(false);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
					
		dataSource.destroy();
	}

}
