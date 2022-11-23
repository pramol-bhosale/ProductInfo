package com.futurism.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductData {

private String name;
private String description;
private Integer price;

@JsonProperty("isActive")
private boolean isActive;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}

@Override
public String toString() {
   return "[ name = "+this.name+" , description = "+this.description+", price = "+this.price+" , isActive = "+this.isActive+" ]";	
}
}
