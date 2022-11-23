package com.futurism.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.futurism.model.ProductDetails;
import com.futurism.model.ProductMaster;


@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
	@Modifying
	@Transactional 
	@Query(value="select * from product_details",nativeQuery = true)
	public List<ProductDetails> getProducts();
	
	@Modifying
	@Transactional 
	@Query(value="update product_details set is_active = ?2 where id=?1", nativeQuery = true)
	public Integer updateStatus(Integer id, boolean isActive);
	
	@Modifying
	@Transactional 
	@Query(value="update product_details set description=?2, is_active=?3 where id = ?1", nativeQuery = true)
	public Integer updateProduct(Integer id, String description, boolean isActive);

	@Modifying
	@Transactional 
	@Query(value="insert into product_details(description, is_active, product_master_id)values(?1, ?2, ?3)", nativeQuery = true)
	public Integer createProduct(String description, boolean isActive, ProductMaster productMaster);
	
}
