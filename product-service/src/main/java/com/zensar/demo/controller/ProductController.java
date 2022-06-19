package com.zensar.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.entity.Product;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	private List<Product> products = new ArrayList<Product>();

	public ProductController() {
		super();
		products.add(new Product(101, "Laptop", 50000));
		products.add(new Product(102, "Mouse", 500));
		products.add(new Product(103, "Fan", 1500));
	}

	@RequestMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public Product getProduct(@PathVariable("productId") int productId) {
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	@RequestMapping(value = "/products", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	private List<Product> getAllProduct() {
		return products;
	}

	@RequestMapping(value = "/products", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public void insertProduct(@RequestBody Product product) {
		products.add(product);

	}

	@RequestMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.PUT)
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		Product product2 = getProduct(productId);
		product2.setProductId(product.getProductId());
		product2.setProductName(product.getProductName());
		product2.setProductCost(product.getProductCost());

	}

	@RequestMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("productId") int productId) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getProductId() == productId)
				products.remove(product);
		}

	}
}
