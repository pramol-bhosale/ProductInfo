package com.futurism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.futurism.jwtutils.JwtUserDetailsService;
import com.futurism.jwtutils.TokenManager;
import com.futurism.model.JwtRequestModel;
import com.futurism.model.JwtResponseModel;
import com.futurism.model.ProductData;
import com.futurism.model.ProductDetails;
import com.futurism.model.ProductMaster;
import com.futurism.service.*;

@RestController
public class ProductController {

	@Autowired
	ProductDetailsService product_service;
	
	@Autowired
	ProductMasterService product_master_service;
	
	 @Autowired
	   private JwtUserDetailsService userDetailsService;
	   @Autowired
	   private AuthenticationManager authenticationManager;
	   @Autowired
	   private TokenManager tokenManager;
	 
	   @PostMapping("/login")
	   public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request) throws Exception {
	      try {
	         authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(request.getUsername(),
	            request.getPassword())
	         );
	      } catch (DisabledException e) {
	         throw new Exception("USER_DISABLED", e);
	      } catch (BadCredentialsException e) {
	         throw new Exception("INVALID_CREDENTIALS", e);
	      }
	      final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
	      final String jwtToken = tokenManager.generateJwtToken(userDetails);
	      return ResponseEntity.ok(new JwtResponseModel(jwtToken));
	   }
	   
	@GetMapping("/products")
	@ResponseBody
    public ResponseEntity<List<ProductDetails>> getProducts() {
		return new ResponseEntity<List<ProductDetails>>(product_service.getProducts(), HttpStatus.OK);
	}
	
	@PostMapping("/createproduct")
	public String createProduct(@RequestBody ProductData productData) {
		
		ProductMaster productMaster = new ProductMaster();
		productMaster.setName(productData.getName());
		productMaster.setPrice(productData.getPrice());
		ProductMaster pro_master = product_master_service.createProductMaster(productMaster);
	
		if(pro_master.getId() != null) {
			ProductDetails productDetails = new ProductDetails();
			productDetails.setDescription(productData.getDescription());
			productDetails.setProductMasterId(pro_master);
			productDetails.setActive(productData.isActive());
			product_service.createProductDetails(productDetails);
			
		}else {
			return "Something wen wrong!!";
		}
	
		return "Product created successfully";
	}
	
	@PutMapping("/update")
	public Integer updateProduct(@RequestBody ProductDetails productDetails) {
		System.out.println(productDetails);
		int n = product_service.updateProduct(productDetails.getId(), productDetails);
		return n;
	}
	
	@PutMapping("/updatestatus")
	public String updateStatus(@RequestBody ProductDetails productDetails) {
		product_service.updateStatus(productDetails.getId(), productDetails.isActive()); 
		return "Updated successfully";
	}
	
}
