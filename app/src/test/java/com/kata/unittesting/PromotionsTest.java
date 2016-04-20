package com.kata.unittesting;

import com.kata.unittesting.promotion.MultipleProductPromotionApplicator;
import com.kata.unittesting.promotion.PartyPizzaPromotionApplicator;
import com.kata.unittesting.promotion.PromotionApplicator;
import com.kata.unittesting.promotion.SadPartyPromotionApplicator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * PromotionsTest
 * <p>
 * Here we will put de solitary test for all PromotionApplicators
 */
public class PromotionsTest {

    @Test
    public void shouldSadPartyPromotionApplicatorReturnTrueWhenApplyPromotion() {
        List<Product> products = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        products.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY));

        PromotionApplicator sadPartyPromotionApplicator = new SadPartyPromotionApplicator(products);

        assertTrue(sadPartyPromotionApplicator.process());
    }

    @Test
    public void shouldSadPartyPromotionApplicatorReturnFalseWhenCanNotApplyPromotion() {
        List<Product> products = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        products.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY - 1));

        PromotionApplicator sadPartyPromotionApplicator = new SadPartyPromotionApplicator(products);

        assertFalse(sadPartyPromotionApplicator.process());
    }

    @Test
    public void shouldSadPartyPromotionApplicatorReturnNotPromotionProducts() {
        List<Product> products = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        products.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY));
        Product mockProduct = new Product();
        products.add(mockProduct);

        PromotionApplicator sadPartyPromotionApplicator = new SadPartyPromotionApplicator(products);
        sadPartyPromotionApplicator.process();

        assertEquals(1, sadPartyPromotionApplicator.getProducts().size());
        assertEquals(mockProduct, sadPartyPromotionApplicator.getProducts().get(0));
    }


    @Test
    public void shouldPartyPizzaPromotionApplicatorReturnTrueWhenApplyPromotion() {
        List<Product> products = ProductSupplier.getBeers(PartyPizzaPromotionApplicator.PROMOTION_BEER_QUANTITY);
        products.addAll(ProductSupplier.getPizzas(PartyPizzaPromotionApplicator.PROMOTION_PIZZA_QUANTITY));

        PartyPizzaPromotionApplicator partyPizzaPromotionApplicator = new PartyPizzaPromotionApplicator(products);

        assertTrue(partyPizzaPromotionApplicator.process());
    }

    @Test
    public void shouldPartyPizzaPromotionApplicatorReturnFalseWhenCanNotApplyPromotion() {
        List<Product> products = ProductSupplier.getBeers(PartyPizzaPromotionApplicator.PROMOTION_BEER_QUANTITY - 1);
        products.addAll(ProductSupplier.getPizzas(PartyPizzaPromotionApplicator.PROMOTION_PIZZA_QUANTITY));

        PromotionApplicator partyPizzaPromotionApplicator = new PartyPizzaPromotionApplicator(products);

        assertFalse(partyPizzaPromotionApplicator.process());
    }

    @Test
    public void shouldPartyPizzaPromotionApplicatorReturnNotPromotionProducts() {
        List<Product> products = ProductSupplier.getBeers(PartyPizzaPromotionApplicator.PROMOTION_BEER_QUANTITY);
        products.addAll(ProductSupplier.getPizzas(PartyPizzaPromotionApplicator.PROMOTION_PIZZA_QUANTITY));
        Product mockProduct = new Product();
        products.add(mockProduct);

        PromotionApplicator partyPizzaPromotionApplicator = new PartyPizzaPromotionApplicator(products);
        partyPizzaPromotionApplicator.process();

        assertEquals(1, partyPizzaPromotionApplicator.getProducts().size());
        assertEquals(mockProduct, partyPizzaPromotionApplicator.getProducts().get(0));
    }

    @Test
    public void shouldMultiplePromotionApplicatorReturnTrueWhenApplyPromotion() {
        List<Product> mockProduct = ProductSupplier.getColas(MultipleProductPromotionApplicator.PROMOTION_REQUIRED_QUANTITY);

        PromotionApplicator multipleProductPromotionApplicator = new MultipleProductPromotionApplicator(
                mockProduct);

        assertTrue(multipleProductPromotionApplicator.process());
    }

    @Test
    public void shouldMultiplePromotionApplicatorReturnProductsNotApplied() {
        List<Product> mockProduct = ProductSupplier.getColas(MultipleProductPromotionApplicator.PROMOTION_REQUIRED_QUANTITY - 1);

        PromotionApplicator multipleProductPromotionApplicator = new MultipleProductPromotionApplicator(
                mockProduct);

        assertFalse(multipleProductPromotionApplicator.process());
    }

    @Test
    public void shouldMultiplePromotionApplicatorReturnFalseWhenCanNotApplyPromotion() {
        List<Product> mockProduct = ProductSupplier.getColas(MultipleProductPromotionApplicator.PROMOTION_REQUIRED_QUANTITY + 1);

        PromotionApplicator multipleProductPromotionApplicator = new MultipleProductPromotionApplicator(
                mockProduct);
        multipleProductPromotionApplicator.process();

        assertEquals(1, multipleProductPromotionApplicator.getProducts().size());
    }
}
