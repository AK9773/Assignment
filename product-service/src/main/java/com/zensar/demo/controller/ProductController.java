package com.zensar.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.entity.Product;
import com.zensar.demo.service.ProductServices;

@RestController
@RequestMapping(value = "/product-api")
public class ProductController {

	@Autowired
	private ProductServices productServices;

	@GetMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ProductDto getProduct(@PathVariable("productId") int productId) {

		return productServices.getProduct(productId);
	}

	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<ProductDto> getAllProduct() {
		return productServices.getAllProduct();
	}

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ProductDto insertProduct(@RequestBody ProductDto productDto) {
		return productServices.insertProduct(productDto);
	}

	@PutMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) {
		productServices.updateProduct(productId, productDto);
	}

	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		productServices.deleteProduct(productId);

	}
}
