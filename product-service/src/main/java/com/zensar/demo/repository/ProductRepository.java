package com.zensar.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
}
