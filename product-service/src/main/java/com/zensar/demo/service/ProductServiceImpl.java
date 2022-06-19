package com.zensar.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.demo.dto.ProductDto;
import com.zensar.demo.entity.Product;
import com.zensar.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto getProduct(int productId) {

		Product product = productRepository.findById(productId).get();
		return modelMapper.map(product, ProductDto.class);

	}

	@Override
	public List<ProductDto> getAllProduct() {

		List<Product> listOfProduct = productRepository.findAll();
		List<ProductDto> listOfDto = new ArrayList<ProductDto>();
		for (Product product : listOfProduct) {
			listOfDto.add(modelMapper.map(product, ProductDto.class));
		}
		return listOfDto;

	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product product2 = productRepository.save(product);
		return modelMapper.map(product2, ProductDto.class);
	}

	@Override
	public void updateProduct(int productId, ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product product2 = productRepository.save(product);
		modelMapper.map(product2, ProductDto.class);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

}
