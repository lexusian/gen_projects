package com.gen.shopping.cart.bo;

import java.util.Map;

import com.gen.shopping.cart.model.PriceRule;
import com.gen.shopping.cart.model.Selected;

public class DefaultPromo extends Promo {

	
	public double computeTotal(Selected selected, Map<String, PriceRule> priceRules)
	{
		if (!selected.isIgnore()) {
		double price = Double
				.valueOf(priceRules.get(selected.getProduct().getCode()).getProductPrice())
				.doubleValue();
		 
		return selected.getCount() * price;
		}
		else
		{
			return 0.0d;
		}
	}
}
