package com.gen.shopping.cart.bo;

import java.util.Map;

import com.gen.shopping.cart.model.PriceRule;
import com.gen.shopping.cart.model.Selected;

public class Unlimited1GBPromo extends Promo  {
	
	public double computeTotal(Selected selected, Map<String, PriceRule> priceRules)
	{
		int unliOneGbCountDivisible = selected.getCount()
				/ priceRules.get(selected.getProduct().getCode()).getDiscountCount();
		if (unliOneGbCountDivisible > 0) {
			double price = Double
					.valueOf(priceRules.get(selected.getProduct().getCode()).getProductPrice())
					.doubleValue();
			double deduct = price * unliOneGbCountDivisible;
			return selected.getTotal() - deduct;
		}
		else
		{
			return 0.0d;
		}
	}
}
