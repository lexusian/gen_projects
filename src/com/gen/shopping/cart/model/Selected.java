package com.gen.shopping.cart.model;

public class Selected {
	
	private Product product;
	private int count;
	private double total;
	private String promoCode;
	private boolean ignore;
	

	public boolean isIgnore() {
		return ignore;
	}

	public void setIgnore(boolean ignore) {
		this.ignore = ignore;
	}

	public Selected(Product product, int count){
		this.product = product;
		this.count = count;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getPromoCode(){
		return promoCode;
	}
	
	public void setPromoCode(String promoCode){
		this.promoCode = promoCode;
	}
}
