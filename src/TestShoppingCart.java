import static org.junit.Assert.*;

import org.junit.Test;

import com.gen.shopping.cart.constants.Constants;
import com.gen.shopping.cart.model.Product;
import com.gen.shopping.cart.model.Selected;
import com.gen.shopping.cart.service.ShoppingCart;
import com.gen.shopping.cart.service.ShoppingCartImpl;
import com.gen.shopping.util.PricingRulesDefinition;

public class TestShoppingCart {

	@Test
	public void testScenario1() {

		ShoppingCart shoppingCart = new ShoppingCartImpl(PricingRulesDefinition.getPriceRules());

		Product small = new Product(Constants.UNLI_ONE_GB_CODE, Constants.UNLI_ONE_GB_NAME);

		Product large = new Product(Constants.UNLI_FIVE_GB_CODE, Constants.UNLI_FIVE_GB_NAME);

		/* Change the 2nd parameter for the count of the selected item */
		Selected smallSelected = new Selected(small, 3);

		Selected largeSelected = new Selected(large, 1);

		shoppingCart.add(smallSelected);

		shoppingCart.add(largeSelected);

		shoppingCart.items();

		assertEquals((shoppingCart.total() == 94.7), true);
	}

	@Test
	public void testScenario2() {
		ShoppingCart shoppingCart = new ShoppingCartImpl(PricingRulesDefinition.getPriceRules());

		Product small = new Product(Constants.UNLI_ONE_GB_CODE, Constants.UNLI_ONE_GB_NAME);

		Product large = new Product(Constants.UNLI_FIVE_GB_CODE, Constants.UNLI_FIVE_GB_NAME);

		/* Change the 2nd parameter for the count of the selected item */
		Selected smallSelected = new Selected(small, 2);

		Selected largeSelected = new Selected(large, 4);

		shoppingCart.add(smallSelected);

		shoppingCart.add(largeSelected);
		shoppingCart.items();

		assertEquals((shoppingCart.total() == 209.40), true);

	}

	@Test
	public void testScenario3() {
		ShoppingCart shoppingCart = new ShoppingCartImpl(PricingRulesDefinition.getPriceRules());

		Product small = new Product(Constants.UNLI_ONE_GB_CODE, Constants.UNLI_ONE_GB_NAME);
		Product medium = new Product(Constants.UNLI_TWO_GB_CODE, Constants.UNLI_TWO_GB_NAME);

		/* Change the 2nd parameter for the count of the selected item */
		Selected smallSelected = new Selected(small, 1);

		Selected mediumSelected = new Selected(medium, 2);

		shoppingCart.add(smallSelected);

		shoppingCart.add(mediumSelected);
		shoppingCart.items();

		assertEquals((shoppingCart.total() == 84.70), true);

	}

	@Test
	public void testScenario4() {
		ShoppingCart shoppingCart = new ShoppingCartImpl(PricingRulesDefinition.getPriceRules());

		Product small = new Product(Constants.UNLI_ONE_GB_CODE, Constants.UNLI_ONE_GB_NAME);

		Product oneGb = new Product(Constants.UNLI_ONE_GB_DATA_PACK_CODE, Constants.UNLI_ONE_GB_DATA_PACK_NAME);
		/* Change the 2nd parameter for the count of the selected item */

		Selected oneGbSelected = new Selected(oneGb, 1);

		Selected smallSelected = new Selected(small, 1);

		shoppingCart.add(smallSelected);

		shoppingCart.add(oneGbSelected, "I<3AMAYSIM");
		shoppingCart.items();

		assertEquals((shoppingCart.total() == 31.32), true);

	}

}
