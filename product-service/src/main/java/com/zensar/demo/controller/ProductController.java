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

import com.zensar.demo.entity.Product;
import com.zensar.demo.service.ProductServices;

@RestController
@RequestMapping(value = "/product-api", produces = { MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	private ProductServices productServices;

	public ProductController() {
		super();

	}

	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {

		return productServices.getProduct(productId);
	}

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productServices.getAllProduct();
	}

	@PostMapping("/products")
	public void insertProduct(@RequestBody Product product) {
		productServices.insertProduct(product);
	}

	@PutMapping("/products/{productId}")
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		productServices.updateProduct(productId, product);

	}

	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		productServices.deleteProduct(productId);

	}
}
