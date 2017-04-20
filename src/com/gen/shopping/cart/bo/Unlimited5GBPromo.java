package com.gen.shopping.cart.bo;

import java.util.Map;

import com.gen.shopping.cart.model.PriceRule;
import com.gen.shopping.cart.model.Selected;

public class Unlimited5GBPromo extends Promo  {
	
	public double computeTotal(Selected selected, Map<String, PriceRule> priceRules)
	{
		int unliFiveGbCount = selected.getCount();
		if (unliFiveGbCount > priceRules.get(selected.getProduct().getCode()).getDiscountCount()) {
			double deduct = unliFiveGbCount * 5;
			return selected.getTotal() - deduct;
		}
		else
		{
			return 0.0d;
		}
	}
}
