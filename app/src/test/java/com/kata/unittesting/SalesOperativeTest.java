package com.kata.unittesting;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 * <p/>
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
}
