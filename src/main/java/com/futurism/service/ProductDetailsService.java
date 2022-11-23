package com.futurism.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.futurism.model.*;
@Service
 public interface ProductDetailsService {

	/**
	 * method get all product details from database 
	 * @return list of product details
	 */
	 
	public List<ProductDetails> getProducts();
  
	/**
	 * method update the active status of the product 
	 * @param id
	 * @param isActive
	 * @return id of the updated product
	 */
	
	 public Integer updateStatus(Integer id, boolean isActive);
	
	/**
	 * method update the fields of product
	 * @param id
	 * @param productDetails
	 * @return id of the product
	 */
	
	public Integer updateProduct(Integer id, ProductDetails productDetails);
	
	/**
	 * method insert new product in database
	 * @param productDetails
	 */
	public void createProductDetails(ProductDetails productDetails);
}
