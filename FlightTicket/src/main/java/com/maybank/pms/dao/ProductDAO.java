package com.maybank.pms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maybank.pms.model.Product;

public interface ProductDAO extends CrudRepository<Product, Integer> {
	public List<Product> findByPriceBetween(int lowerBound, int upperBound);
	public List<Product> findByQuantityOnHandOrderByProductNameDesc(int quantityOnHand);
	public List<Product> findByProductName(String productName);
}
