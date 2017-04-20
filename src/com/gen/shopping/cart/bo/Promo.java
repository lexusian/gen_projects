package com.gen.shopping.cart.bo;
import java.util.Map;

import com.gen.shopping.cart.model.PriceRule;
import com.gen.shopping.cart.model.Selected;
public abstract class Promo {
   
	public abstract double computeTotal(Selected selected,Map<String, PriceRule> priceRules);
}
