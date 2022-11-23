package com.futurism.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.futurism.model.ProductMaster;

@Entity
@Table(name="ProductDetails")
public class ProductDetails {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JoinColumn(name = "ProductMasterId",referencedColumnName = "id")
  @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
 
  private ProductMaster productMasterId;
  
  @Column(name="Description")
  private String description;
  
  @JsonProperty("isActive")
  @Column(name="IsActive")
  private boolean isActive;
  public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public ProductMaster getProductMasterId() {
	return productMasterId;
}
public void setProductMasterId(ProductMaster productMasterId) {
	this.productMasterId = productMasterId;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}

//constructor
public ProductDetails() {
	  
}
@Override
public String toString() {
	return "[id = "+this.id+" , description= "+this.description+" , isActive="+this.isActive+", productMasterId="+this.productMasterId+" ]";
}
	
}
