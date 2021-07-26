package com.maybank.pms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.pms.dao.ProductDAO;
import com.maybank.pms.model.Product;
import com.maybank.pms.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	boolean result = false;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts()
	{
		ResponseEntity<List<Product>> responseEntity=null;
		List<Product> products = new ArrayList<Product>();
		products=productService.viewProducts();
		 if(products.size()==0)
			 responseEntity= new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		 else
			 responseEntity= new ResponseEntity<List<Product>> (products,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		ResponseEntity<String> responseEntity=null;
		if(productService.isProductExists(product.getProductId()))
		{
			responseEntity= new ResponseEntity<String>("Product already exists with product id: "+product.getProductId(),HttpStatus.CONFLICT);
		}
		else
		{
			result= productService.addProduct(product);
			if(result)
				responseEntity= new ResponseEntity<String>("Product saved successfully : "+product.getProductId(),HttpStatus.CREATED);
			else
				responseEntity= new ResponseEntity<String>("Please check the Id, price and quantity, they must be greater than zero  : "+product.getProductId(),HttpStatus.NOT_ACCEPTABLE);
		}
			return responseEntity;
	}
	@PutMapping
	public ResponseEntity<String> updateProducts(@RequestBody Product product)
	{
		ResponseEntity<String> responseEntity=null;
		if(productService.isProductExists(product.getProductId()))
		{
			result= productService.updateProduct(product);
			if(result)
				responseEntity= new ResponseEntity<String>("Product updated successfully : "+product.getProductId(),HttpStatus.OK);
			else
				responseEntity= new ResponseEntity<String>("Please check the price and quantity, they must be greater than zero  : "+product.getProductId(),HttpStatus.NOT_ACCEPTABLE);
		}
		else
		{
			responseEntity= new ResponseEntity<String>("Product doen't exists with product id: "+product.getProductId(),HttpStatus.NO_CONTENT);
		}
			return responseEntity;
	}
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProducts(@PathVariable("productId")int productId)
	{
		ResponseEntity<String> responseEntity=null;
		if(productService.isProductExists(productId))
		{
			
			Optional<Product> product = productService.searchProductById(productId);
			Product deletedProduct=product.get();
			result= productService.deleteProduct(productId);
			responseEntity= new ResponseEntity<String>("Product deleted successfully : "+deletedProduct,HttpStatus.OK);
			
		}
		else
		{
			responseEntity= new ResponseEntity<String>("Product doen't exists with product id: "+productId,HttpStatus.NO_CONTENT);
		}
			return responseEntity;
		
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<Product>searchProduct(@PathVariable("productId")int productId)
	{
		ResponseEntity<Product> responseEntity=null;
		Product foundProduct = new Product();
		if(productService.isProductExists(productId))
		{
			Optional<Product> product = productService.searchProductById(productId);
			foundProduct =product.get();
			responseEntity= new ResponseEntity<Product>(foundProduct,HttpStatus.OK);
		}
		else
		{
			responseEntity= new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
			
		return responseEntity;
		
	}
	@GetMapping("/search/{productName}")
	public ResponseEntity<List<Product>> searchProducts(@PathVariable("productName")String productName)
	{
		ResponseEntity<List<Product>> responseEntity=null;
		 List<Product> searchProducts = new ArrayList<Product>();
		 searchProducts = productService.searchProductByName(productName);
		 if(searchProducts.size()==0)
			 responseEntity= new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		 else
			 responseEntity= new ResponseEntity<List<Product>>(searchProducts,HttpStatus.OK);
		return responseEntity;
	}

	
}