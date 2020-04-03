package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.authentication.JwtAuthInterceptor;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MainApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/TESnippets");
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/te-snippets");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		return dataSource;
	}
	
	@Bean
	public JwtAuthInterceptor interceptor() {
		List<String> exceptions = new ArrayList<String>();
		exceptions.add("/register");
		exceptions.add("/login");
		return new JwtAuthInterceptor(exceptions);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor());
	}

}
