package com.kata.unittesting.promotion;

import com.kata.unittesting.Product;
import com.kata.unittesting.ProductSupplier;

import java.util.Collections;
import java.util.List;

/**
 * SadPartyPromotionApplicator
 */
public class SadPartyPromotionApplicator extends PromotionApplicator {

    public static final double PROMOTION_AMOUNT = 5;

    public final static int PROMOTION_COLA_QUANTITY = 4;

    public final static int PROMOTION_CHIPS_QUANTITY = 2;

    public SadPartyPromotionApplicator(List<Product> products) {
        super(products);
    }

    @Override
    public boolean process() {
        Product cola = ProductSupplier.getCola();
        Product chips = ProductSupplier.getChips();

        if (Collections.frequency(products, cola) >= PROMOTION_COLA_QUANTITY
                && Collections.frequency(products, chips) >= PROMOTION_CHIPS_QUANTITY) {
            removeProducts(cola, PROMOTION_COLA_QUANTITY);
            removeProducts(chips, PROMOTION_CHIPS_QUANTITY);

            return true;
        }

        return false;
    }

    @Override
    public double getPromotionAmount() {
        return PROMOTION_AMOUNT;
    }
}
