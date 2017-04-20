package com.gen.shopping.cart.model;

public class Product {

	private String code;
	private String name;
	private double price;

	public Product(String code, String name){
		this.code = code;
		this.name = name;
	}
	
		
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
