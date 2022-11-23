package com.futurism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurism.model.ProductMaster;
import com.futurism.repository.*;
@Service
public class ProductMasterServiceImpl implements ProductMasterService {

	@Autowired 
	ProductMasterRepository product_master_repo;
	
	@Override
	public ProductMaster createProductMaster(ProductMaster productMaster) {
		
		return product_master_repo.save(productMaster);
		
	}

}
