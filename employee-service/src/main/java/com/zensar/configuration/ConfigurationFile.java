package com.zensar.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zensar.repository.EmployeeRepository;
import com.zensar.repository.EmployeeRepositoryImpl;

@Configuration
public class ConfigurationFile {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/MyDatabase");
		dataSource.setUsername("root");
		dataSource.setPassword("Temp1234");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public EmployeeRepository employeeRepository() {
		EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
		employeeRepositoryImpl.setJdbcTemplate(jdbcTemplate());
		return employeeRepositoryImpl;
	}

}
