package com.zensar.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "test", "com.zensar" })
public class ProductServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

	}

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}
	
	

}
