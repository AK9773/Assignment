package com.zensar.demo.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.zensar.demo.entity.Product;


@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	private List<Product> products = new ArrayList<Product>();
	
	

	public ProductRepositoryImpl() {
		super();
		products.add(new Product(101, "Laptop", 50000));
		products.add(new Product(102, "Mouse", 500));
		products.add(new Product(103, "Fan", 1500));
	}

	@Override
	public Product getProduct(int productId) {
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return products;
	}
	

	@Override
	public void insertProduct(Product product) {
		products.add(product);
		
	}

	@Override
	public void updateProduct(int productId, Product product) {
		Product product2 = getProduct(productId);
		product2.setProductId(product.getProductId());
		product2.setProductName(product.getProductName());
		product2.setProductCost(product.getProductCost());
		
	}

	@Override
	public void deleteProduct(int productId) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getProductId() == productId)
				products.remove(product);
		}
		
	}
	

}
