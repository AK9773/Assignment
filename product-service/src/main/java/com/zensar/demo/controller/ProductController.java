package com.zensar.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.service.ProductServices;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	private ProductServices productServices;

	@GetMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {

		return new ResponseEntity<ProductDto>(productServices.getProduct(productId),HttpStatus.OK);
	}

	@GetMapping(value = "/products", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductDto>> getAllProduct() {
		return new ResponseEntity<List<ProductDto>>(productServices.getAllProduct(), HttpStatus.OK);
	}

	@PostMapping(value = "/products", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>(productServices.insertProduct(productDto),HttpStatus.CREATED);
	}

	@PutMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) {
		productServices.updateProduct(productId, productDto);
		return new ResponseEntity<String>("Product Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productServices.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);

	}
}
