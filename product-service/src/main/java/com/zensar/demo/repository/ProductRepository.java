package com.zensar.demo.repository;

import java.util.List;

import com.zensar.demo.entity.Product;

public interface ProductRepository {

	public Product getProduct(int productId);

	public List<Product> getAllProduct();

	public void insertProduct(Product product);

	public void updateProduct(int productId, Product product);

	public void deleteProduct(int productId);
	
	
}
