package com.futurism.service;

import org.springframework.stereotype.Service;

import com.futurism.model.*;
@Service
public interface ProductMasterService {

	/**
	 * method create the record in the productMaster table
	 * @param productMaster
	 * @return productMaster
	 */
	
	public ProductMaster createProductMaster(ProductMaster productMaster);
	
}
