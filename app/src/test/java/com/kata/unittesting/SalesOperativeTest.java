package com.kata.unittesting;

import com.kata.unittesting.promotion.MultipleProductPromotionApplicator;
import com.kata.unittesting.promotion.PartyPizzaPromotionApplicator;
import com.kata.unittesting.promotion.SadPartyPromotionApplicator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 * <p>
 * Here we will test the sales operative collaborators, know as sociable tests
 */
public class SalesOperativeTest {

    private static final int DELTA = 0;

    private static final int MOCK_PRODUCTS_SIZE = 5;

    private static final double MOCK_AMOUNT = 2.5;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldShoppingCalculatorThrowExceptionWithNullBasket() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(ShoppingCalculator.CAN_T_BE_CALCULATED_A_NULL_BASKET);

        ShoppingCalculator.processBasket(null);
    }

    @Test
    public void shouldShoppingCalculatorProcessAnEmptyBasket() {
        Basket emptyBasket = new Basket();

        double amount = ShoppingCalculator.processBasket(emptyBasket);

        assertEquals(0, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorProcessABasketWithProduct() {
        Product mockProduct = new Product(0, MOCK_AMOUNT, Product.Type.HOT);
        Basket basket = new Basket(mockProduct);

        double amount = ShoppingCalculator.processBasket(basket);

        assertEquals(MOCK_AMOUNT, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorProcessABasketWithMultipleProducts() {
        List<Product> mockProducts = new ArrayList<>();
        for (int i = 0; i < MOCK_PRODUCTS_SIZE; i++) {
            mockProducts.add(new Product(i, MOCK_AMOUNT, Product.Type.COLD));
        }
        Basket basket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(basket);

        assertEquals(MOCK_AMOUNT * MOCK_PRODUCTS_SIZE, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorApplySadPartyPromotion() {
        List<Product> mockProducts = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        mockProducts.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY));
        Basket mockBasket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(mockBasket);

        assertEquals(SadPartyPromotionApplicator.PROMOTION_AMOUNT, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorApplySadPartyPromotions() {
        List<Product> mockProducts = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY * 2);
        mockProducts.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY * 2));
        Basket mockBasket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(mockBasket);

        assertEquals(SadPartyPromotionApplicator.PROMOTION_AMOUNT * 2, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorProcessBasketAndApplySadPartyPromotion() {
        List<Product> mockProducts = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        mockProducts.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY));
        Product mockProduct = new Product(0, MOCK_AMOUNT, Product.Type.HOT);
        mockProducts.add(mockProduct);
        Basket mockBasket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(mockBasket);

        assertEquals(SadPartyPromotionApplicator.PROMOTION_AMOUNT + MOCK_AMOUNT, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorApplyPartyPizzaPromotion() {
        List<Product> mockProducts = ProductSupplier.getBeers(PartyPizzaPromotionApplicator.PROMOTION_BEER_QUANTITY);
        mockProducts.addAll(ProductSupplier.getPizzas(PartyPizzaPromotionApplicator.PROMOTION_PIZZA_QUANTITY));
        Basket mockBasket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(mockBasket);

        assertEquals(PartyPizzaPromotionApplicator.PROMOTION_AMOUNT, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorApplyPartyPizzaPromotions() {
        List<Product> mockProducts = ProductSupplier.getBeers(PartyPizzaPromotionApplicator.PROMOTION_BEER_QUANTITY * 2);
        mockProducts.addAll(ProductSupplier.getPizzas(PartyPizzaPromotionApplicator.PROMOTION_PIZZA_QUANTITY * 2));
        Basket mockBasket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(mockBasket);

        assertEquals(PartyPizzaPromotionApplicator.PROMOTION_AMOUNT * 2, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorProcessBasketAndApplypartyPizzaPromotion() {
        List<Product> mockProducts = ProductSupplier.getBeers(PartyPizzaPromotionApplicator.PROMOTION_BEER_QUANTITY);
        mockProducts.addAll(ProductSupplier.getPizzas(PartyPizzaPromotionApplicator.PROMOTION_PIZZA_QUANTITY));
        Product mockProduct = new Product(0, MOCK_AMOUNT, Product.Type.HOT);
        mockProducts.add(mockProduct);
        Basket mockBasket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(mockBasket);

        assertEquals(PartyPizzaPromotionApplicator.PROMOTION_AMOUNT + MOCK_AMOUNT, amount, DELTA);
    }

    @Test
    public void shouldShoppingCalculatorApplySadPartyAndPartyPizzaPromotionsO() {
        List<Product> mockProducts = ProductSupplier.getColas(SadPartyPromotionApplicator.PROMOTION_COLA_QUANTITY);
        mockProducts.addAll(ProductSupplier.getChips(SadPartyPromotionApplicator.PROMOTION_CHIPS_QUANTITY));
        mockProducts.addAll(ProductSupplier.getBeers(PartyPizzaPromotionApplicator.PROMOTION_BEER_QUANTITY));
        mockProducts.addAll(ProductSupplier.getPizzas(PartyPizzaPromotionApplicator.PROMOTION_PIZZA_QUANTITY));
        Basket mockBasket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(mockBasket);

        assertEquals(SadPartyPromotionApplicator.PROMOTION_AMOUNT + PartyPizzaPromotionApplicator.PROMOTION_AMOUNT, amount,
                DELTA);
    }

    @Test
    public void shouldShoppingCalculatorApplyMultipleProductPromotion() {
        List<Product> mockProducts = ProductSupplier.getColas(MultipleProductPromotionApplicator.PROMOTION_REQUIRED_QUANTITY);
        Basket basket = new Basket(mockProducts);

        double amount = ShoppingCalculator.processBasket(basket);

        assertEquals(ProductSupplier.getCola().getPrice() * MultipleProductPromotionApplicator.PROMOTION_PAY_QUANTITY, amount,
                DELTA);
    }
}
