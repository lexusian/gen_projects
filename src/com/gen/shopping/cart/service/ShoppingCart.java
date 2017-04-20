package com.gen.shopping.cart.service;

import java.util.List;

import com.gen.shopping.cart.model.Product;
import com.gen.shopping.cart.model.Selected;

public interface ShoppingCart {

	void add(Selected selected);

	void add(Selected selected, String promoCode);
	
	double total();

	void items();
	
		
	
}
