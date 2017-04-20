package com.gen.shopping.cart.model;

public class PriceRule {
	
	private int disc_count;
	private String product_field;
	private String promo_discount;
	private String product_price;
	
	public String getProductPrice() {
		return product_price;
	}
	public void setProductPrice(String product_price) {
		this.product_price = product_price;
	}
	public int getDiscountCount() {
		return disc_count;
	}
	public void setDiscountCount(int disc_count) {
		this.disc_count = disc_count;
	}
	public String getProductField() {
		return product_field;
	}
	public void setProductField(String product_field) {
		this.product_field = product_field;
	}
	public String getPromoDiscount() {
		return promo_discount;
	}
	public void setPromoDiscount(String promo_discount) {
		this.promo_discount = promo_discount;
	}
	
	
	

}
