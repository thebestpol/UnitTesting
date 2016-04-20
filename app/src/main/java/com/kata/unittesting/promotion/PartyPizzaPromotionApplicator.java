package com.kata.unittesting.promotion;

import com.kata.unittesting.Product;
import com.kata.unittesting.ProductSupplier;

import java.util.Collections;
import java.util.List;

/**
 * PartyPizzaPromotionApplicator
 */
public class PartyPizzaPromotionApplicator extends PromotionApplicator {

    public static final double PROMOTION_AMOUNT = 7;

    public final static int PROMOTION_BEER_QUANTITY = 2;

    public final static int PROMOTION_PIZZA_QUANTITY = 1;

    public PartyPizzaPromotionApplicator(List<Product> products) {
        super(products);
    }

    @Override
    public boolean process() {
        Product beer = ProductSupplier.getBeer();
        Product pizza = ProductSupplier.getPizza();

        if (Collections.frequency(products, beer) >= PROMOTION_BEER_QUANTITY
                && Collections.frequency(products, pizza) >= PROMOTION_PIZZA_QUANTITY) {
            removeProducts(beer, PROMOTION_BEER_QUANTITY);
            removeProducts(pizza, PROMOTION_PIZZA_QUANTITY);

            return true;
        }

        return false;
    }

    @Override
    public double getPromotionAmount() {
        return PROMOTION_AMOUNT;
    }
}
