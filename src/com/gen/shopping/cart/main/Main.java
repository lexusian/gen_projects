package com.gen.shopping.cart.main;

import com.gen.shopping.cart.constants.Constants;
import com.gen.shopping.cart.model.Product;
import com.gen.shopping.cart.model.Selected;
import com.gen.shopping.cart.service.ShoppingCart;
import com.gen.shopping.cart.service.ShoppingCartImpl;
import com.gen.shopping.util.PricingRulesDefinition;

public class Main {

	public static void main(String[] args) {

		ShoppingCart shoppingCart = new ShoppingCartImpl(PricingRulesDefinition.getPriceRules());

		Product small = new Product(Constants.UNLI_ONE_GB_CODE, Constants.UNLI_ONE_GB_NAME);
		Product medium = new Product(Constants.UNLI_TWO_GB_CODE, Constants.UNLI_TWO_GB_NAME);
		Product large = new Product(Constants.UNLI_FIVE_GB_CODE, Constants.UNLI_FIVE_GB_NAME);
		Product oneGb = new Product(Constants.UNLI_ONE_GB_DATA_PACK_CODE, Constants.UNLI_ONE_GB_DATA_PACK_NAME);

		/* Comment/uncomment to activate or deactivate the Promotion Code */
//		String promoCode = "I<3AMAYSIM";
		 String promoCode = "";

		/* Change the 2nd parameter for the count of the selected item */
		Selected smallSelected = new Selected(small, 3);
		Selected mediumSelected = new Selected(medium, 2);
		Selected largeSelected = new Selected(large, 1);
		Selected oneGbSelected = new Selected(oneGb, 1);

		/* Comment/Uncomment to add the selected item/s*/
		if (Constants.PROMO_CODE.equals(promoCode)) {
			shoppingCart.add(smallSelected, promoCode);
			// shoppingCartServiceImpl.add(mediumSelected, promoCode);
			// shoppingCartServiceImpl.add(largeSelected, promoCode);
			shoppingCart.add(oneGbSelected, promoCode);
		} else {
			shoppingCart.add(smallSelected);
//			shoppingCartServiceImpl.add(mediumSelected);
			shoppingCart.add(largeSelected);
			// shoppingCartServiceImpl.add(oneGbSelected);
		}

				
		shoppingCart.items();
		shoppingCart.total();
		
	}

}
