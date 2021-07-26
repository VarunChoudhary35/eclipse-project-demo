package com.maybank.pms.service;

import java.util.List;
import java.util.Optional;

import com.maybank.pms.model.Product;

public interface ProductService {
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productId);
	public List<Product> viewProducts();
	public Optional<Product> searchProductById(int productId);
	public List<Product> searchProductByName(String productName);
	public boolean isProductExists(int productId);
	public List<Product> filterProductByPrice(int lowerBound,int upperBound);
}