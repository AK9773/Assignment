package com.zensar.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.entity.Product;
import com.zensar.demo.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductServices{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto getProduct(int productId) {
		
		Product product = productRepository.findById(productId).get();
		ProductDto productDto = mapToDto(product);
		return productDto;
		
	}

	@Override
	public List<ProductDto> getAllProduct() {
		
		List<Product> listOfProduct = productRepository.findAll();
		List<ProductDto> listOfDto = new ArrayList<ProductDto>();
		for(Product product:listOfProduct) {
			ProductDto productDto = mapToDto(product);
			listOfDto.add(productDto);		
		}
		return listOfDto;
		
	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
		Product product = mapToEntity(productDto);
		Product product2 = productRepository.save(product);
		ProductDto productDto2 = mapToDto(product2);
		return productDto2;
	}

	@Override
	public void updateProduct(int productId, ProductDto productDto) {
		Product product = mapToEntity(productDto);
		Product product2 = productRepository.save(product);
		mapToDto(product2);
		
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
		
	}
	
	public Product mapToEntity(ProductDto productDto) { 
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setProductCost(productDto.getProductCost());
		return product;
	}
	
	public ProductDto mapToDto(Product product) { 
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setProductCost(product.getProductCost());
		return productDto;
	}

}
