package com.zensar.demo.service;

import java.util.List;

import com.zensar.demo.entity.Product;

public interface ProductServices {
	
	public Product getProduct(int productId);
	
	public List<Product> getAllProduct();
	
	public void insertProduct(Product product);
	
	public void updateProduct(int productId,Product product);
	
	public void deleteProduct(int productId);
	
}
