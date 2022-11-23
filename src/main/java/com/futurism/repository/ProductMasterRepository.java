package com.futurism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.futurism.model.ProductMaster;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {

	@Query(value="insert into ProductMaster(Name, Price) values (?1, ?2)",nativeQuery = true)
	public ProductMaster createMaster(ProductMaster productMaster);

}
