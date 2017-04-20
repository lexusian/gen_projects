package com.gen.shopping.cart.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gen.shopping.cart.constants.Constants;
import com.gen.shopping.cart.model.PriceRule;
import com.gen.shopping.cart.model.Product;
import com.gen.shopping.cart.model.Selected;

public class ShoppingCartImpl implements ShoppingCart {

	private List<Selected> selectedItems = new ArrayList<>();

	private List<Double> totalPricePerItem = new ArrayList<>();
	private double totalOfPrices = 0;
	private Map<String, PriceRule> priceRules;

	public ShoppingCartImpl(Map<String, PriceRule> priceRules) {
		this.priceRules = priceRules;
	}

	@Override
	public void add(Selected selected) {
		selectedItems.add(selected);
	}

	@Override
	public void add(Selected selected, String promoCode) {

		selected.setPromoCode(promoCode);

		selectedItems.add(selected);
		// applyPricingRules();
	}

	private int totalPromoCodes() {

		int promoCount = 0;

		for (int i = 0; i < selectedItems.size(); i++) {

			if (Constants.PROMO_CODE.equals(selectedItems.get(i).getPromoCode())) {
				promoCount++;
			}
		}

		return promoCount;
	}

	@Override
	public double total() {

		if (totalPricePerItem != null && totalPricePerItem.isEmpty()) {
			items();
		}

		for (int k = 0; k < totalPricePerItem.size(); k++) {
			totalOfPrices = totalOfPrices + totalPricePerItem.get(k);
		}

		int promoCount = totalPromoCodes();

		if (promoCount > 0) {
			double discountRate = Double.valueOf(
					priceRules.get(selectedItems.get(0).getProduct().getCode()).getPromoDiscount()) * promoCount;
			double totalDiscount = discountRate * totalOfPrices;

			totalOfPrices = totalOfPrices - totalDiscount;
		}
		System.out.println("Cart Total:\n$" + Math.round(totalOfPrices * 100D) / 100D);
		DecimalFormat df = new DecimalFormat("0.00");
		String formate = df.format(totalOfPrices);
		double finalValue = 0.0;
		try {
			finalValue = (Double) df.parse(formate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalValue;
	}

	@Override
	public void items() {
		applyPricingRules();
		System.out.println("Card Items:");
		for (int j = 0; j < selectedItems.size(); j++) {
			totalPricePerItem.add(selectedItems.get(j).getTotal());
			System.out.println(selectedItems.get(j).getCount() + "x " + selectedItems.get(j).getProduct().getName());
		}
	}

	private void applyPricingRules() {
		// TODO Auto-generated method stub
		int unliOneGbCountDivisible = 0;
		double deduct = 0;
		for (int i = 0; i < selectedItems.size(); i++) {

			if (!selectedItems.get(i).isIgnore()) {
				double price = Double
						.valueOf(priceRules.get(selectedItems.get(i).getProduct().getCode()).getProductPrice())
						.doubleValue();
				selectedItems.get(i).setTotal(selectedItems.get(i).getCount() * price);
			}
			// }

			if (Constants.UNLI_ONE_GB_NAME.equals(selectedItems.get(i).getProduct().getName())) {
				unliOneGbCountDivisible = selectedItems.get(i).getCount()
						/ priceRules.get(selectedItems.get(i).getProduct().getCode()).getDiscountCount();
				if (unliOneGbCountDivisible > 0) {
					double price = Double
							.valueOf(priceRules.get(selectedItems.get(i).getProduct().getCode()).getProductPrice())
							.doubleValue();
					deduct = price * unliOneGbCountDivisible;
					selectedItems.get(i).setTotal(selectedItems.get(i).getTotal() - deduct);
				}
			}
			if (Constants.UNLI_FIVE_GB_NAME.equals(selectedItems.get(i).getProduct().getName())) {
				int unliFiveGbCount = selectedItems.get(i).getCount();
				if (unliFiveGbCount > priceRules.get(selectedItems.get(i).getProduct().getCode()).getDiscountCount()) {
					deduct = unliFiveGbCount * 5;
					selectedItems.get(i).setTotal(selectedItems.get(i).getTotal() - deduct);
				}
			}
			if (Constants.UNLI_TWO_GB_NAME.equals(selectedItems.get(i).getProduct().getName())) {
				int count = selectedItems.get(i).getCount();
				Product addedOneGb = new Product(Constants.UNLI_ONE_GB_DATA_PACK_CODE,
						Constants.UNLI_ONE_GB_DATA_PACK_NAME);
				Selected addedSelection = new Selected(addedOneGb, count);
				addedSelection.setIgnore(true);
				selectedItems.add(addedSelection);
			}
		}
	}

}
