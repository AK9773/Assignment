package com.zensar.demo.service;

import java.util.List;

import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.entity.Product;

public interface ProductServices {

	public ProductDto getProduct(int productId);

	public List<ProductDto> getAllProduct();

	public ProductDto insertProduct(ProductDto productDto);

	public void updateProduct(int productId, ProductDto productDto);

	public void deleteProduct(int productId);

}
