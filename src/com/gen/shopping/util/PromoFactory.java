package com.gen.shopping.util;

import com.gen.shopping.cart.constants.Constants;
import com.gen.shopping.cart.bo.DefaultPromo;
import com.gen.shopping.cart.bo.Promo;
import com.gen.shopping.cart.bo.Unlimited1GBPromo;
import com.gen.shopping.cart.bo.Unlimited5GBPromo;
public class PromoFactory {
 
	
	public static Promo getPromoBusinessLogic(String productName)
	{
		if(Constants.UNLI_ONE_GB_NAME.equalsIgnoreCase(productName))
		{
			return new Unlimited1GBPromo();
		}
		else if(Constants.UNLI_FIVE_GB_NAME.equalsIgnoreCase(productName))
		{
			return new Unlimited5GBPromo();
		}
		else
		{	
			return new DefaultPromo();
		}
	}
}
