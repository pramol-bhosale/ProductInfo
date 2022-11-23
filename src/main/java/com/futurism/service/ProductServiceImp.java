package com.futurism.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurism.model.ProductDetails;
import com.futurism.repository.*;

@Service
public class ProductServiceImp implements ProductDetailsService {
 @Autowired
 ProductDetailsRepository product_repo;
 
	@Override
	public List<ProductDetails> getProducts() {
		// TODO Auto-generated method stub
	
		return product_repo.getProducts();
	}

	@Override
	public Integer updateStatus(Integer id, boolean isActive) {

		return product_repo.updateStatus(id,isActive);
	}

	@Override
	public Integer updateProduct(Integer id, ProductDetails productDetails) {
		
		return product_repo.updateProduct(id, productDetails.getDescription(), productDetails.isActive());
	}

	@Override
	public void createProductDetails(ProductDetails productDetails) {
		System.out.println("in the service");
		product_repo.createProduct(productDetails.getDescription(), productDetails.isActive(), productDetails.getProductMasterId());
		
	}

}
