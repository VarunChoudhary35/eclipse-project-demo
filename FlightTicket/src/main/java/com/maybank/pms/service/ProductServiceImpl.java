package com.maybank.pms.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.pms.dao.ProductDAO;
import com.maybank.pms.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public boolean addProduct(Product product) {
		if(product.getPrice() <0 || product.getQuantityOnHand() <0 || product.getProductId()<0)
		return false;
		else 
		{
			productDAO.save(product);
			return true;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		if(product.getPrice() <0 || product.getQuantityOnHand() <0 || product.getProductId()<0)
			return false;
			else 
			{
				productDAO.save(product);
				return true;
			}
	}

	@Override
	public boolean deleteProduct(int productId) {
		productDAO.deleteById(productId);
		return true;
	}

	@Override
	public List<Product> viewProducts() {
		 List<Product> products = new ArrayList<Product>();
		products=(List<Product>) productDAO.findAll();
		return products;
	}

	@Override
	public Optional<Product> searchProductById(int productId) {
		Optional<Product> product = productDAO.findById(productId);
		return product;
	}

	@Override
	public List<Product> searchProductByName(String productName) {
		 List<Product> searchProducts = productDAO.findByProductName(productName);
		 return searchProducts;
	}

	@Override
	public boolean isProductExists(int productId) {
		if(productDAO.existsById(productId))
			return true;
		else
			return false;
	}

	@Override
	public List<Product> filterProductByPrice(int lowerBound, int upperBound) {
		List<Product> filterProduct = productDAO.findByPriceBetween(lowerBound, upperBound);
		return filterProduct;
	}

}
