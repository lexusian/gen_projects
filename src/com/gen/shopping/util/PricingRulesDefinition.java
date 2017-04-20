package com.gen.shopping.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.gen.shopping.cart.constants.Constants;
import com.gen.shopping.cart.model.PriceRule;

public class PricingRulesDefinition {
	
	public static Map<String, PriceRule> getPriceRules()
	{
		Map<String, PriceRule> priceRules=new HashMap<String, PriceRule>();
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("pricing.properties");

			// load a properties file
			prop.load(input);

		    PriceRule rule1=new PriceRule();
			
			rule1.setProductField(Constants.UNLI_ONE_GB_CODE);
			rule1.setProductPrice(prop.getProperty(Constants.UNLI_ONE_GB_CODE));
			rule1.setDiscountCount(Integer.valueOf(prop.getProperty(Constants.UNLI_ONE_GB_CODE_DISC_COUNT)));
			rule1.setPromoDiscount(prop.getProperty(Constants.PROMO_DISCOUNT));
			
			
			priceRules.put(Constants.UNLI_ONE_GB_CODE, rule1);
			
			
			PriceRule rule2=new PriceRule();
			rule2.setProductField(Constants.UNLI_TWO_GB_CODE);
			rule2.setProductPrice(prop.getProperty(Constants.UNLI_TWO_GB_CODE));
			rule2.setDiscountCount(Integer.valueOf(prop.getProperty(Constants.UNLI_TWO_GB_CODE_DISC_COUNT)));
			rule2.setPromoDiscount(prop.getProperty(Constants.PROMO_DISCOUNT));
								
			priceRules.put(Constants.UNLI_TWO_GB_CODE, rule2);
			
			
			PriceRule rule3=new PriceRule();
			rule3.setProductField(Constants.UNLI_FIVE_GB_CODE);
			rule3.setProductPrice(prop.getProperty(Constants.UNLI_FIVE_GB_CODE));
			rule3.setDiscountCount(Integer.valueOf(prop.getProperty(Constants.UNLI_FIVE_GB_CODE_DISC_COUNT)));
			rule3.setPromoDiscount(prop.getProperty(Constants.PROMO_DISCOUNT));
			
			
			priceRules.put(Constants.UNLI_FIVE_GB_CODE, rule3);
			
			
			PriceRule rule4=new PriceRule();
			rule4.setProductField(Constants.UNLI_ONE_GB_DATA_PACK_CODE);
			rule4.setProductPrice(prop.getProperty(Constants.UNLI_ONE_GB_DATA_PACK_CODE));
			rule4.setDiscountCount(Integer.valueOf(prop.getProperty(Constants.UNLI_ONE_GB_DATA_PACK_CODE_DISC_COUNT)));
			rule4.setPromoDiscount(prop.getProperty(Constants.PROMO_DISCOUNT));
					
			
			priceRules.put(Constants.UNLI_ONE_GB_DATA_PACK_CODE, rule4);
						

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return priceRules;
	}

}
