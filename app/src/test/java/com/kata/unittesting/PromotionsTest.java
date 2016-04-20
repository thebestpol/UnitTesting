package com.kata.unittesting;

import com.kata.unittesting.promotion.SadPartyPromotionApplicator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * PromotionsTest
 * <p/>
 * Here we will put de solitary test for all PromotionApplicators
 */
public class PromotionsTest {

    @Test
    public void shouldSadPartyPromotionApplicatorReturnTrueWhenApplyPromotion() {
        List<Product> products = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        products.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY));

        SadPartyPromotionApplicator sadPartyPromotionApplicator = new SadPartyPromotionApplicator(products);

        assertTrue(sadPartyPromotionApplicator.process());
    }

    @Test
    public void shouldSadPartyPromotionApplicatorReturnFalseWhenCanNotApplyPromotion() {
        List<Product> products = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        products.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY - 1));

        SadPartyPromotionApplicator sadPartyPromotionApplicator = new SadPartyPromotionApplicator(products);

        assertFalse(sadPartyPromotionApplicator.process());
    }

    @Test
    public void shouldSadPartyPromotionApplicatorReturnNotPromotionProducts() {
        List<Product> products = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        products.addAll(ProductSupplier.getChips(2));
        Product mockProduct = new Product();
        products.add(mockProduct);

        SadPartyPromotionApplicator sadPartyPromotionApplicator = new SadPartyPromotionApplicator(products);
        sadPartyPromotionApplicator.process();

        assertEquals(1, sadPartyPromotionApplicator.getProducts().size());
        assertEquals(mockProduct, sadPartyPromotionApplicator.getProducts().get(0));
    }
}
