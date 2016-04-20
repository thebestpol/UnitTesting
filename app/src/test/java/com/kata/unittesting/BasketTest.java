package com.kata.unittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * BasketTest
 */
public class BasketTest {

    private static final int DELTA = 0;

    private static final int MOCK_PRODUCTS_SIZE = 5;

    private static final double MOCK_AMOUNT = 2.5;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldBasketContainsAList() {
        Basket basket = new Basket();

        assertEquals(isList(), basket.getContent());
    }

    private List<Object> isList() {
        return new ArrayList<>();
    }

    @Test
    public void shouldBasketNeverReturnNull() {
        Basket basket = new Basket();

        assertNotNull(basket.getContent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBasketThrowIllegalArgumentExceptionWithNullProducts() {
        Product product = null;
        new Basket(product);
    }

    @Test
    public void shouldBasketThrowMessageExceptionWithNullProduct() {
        Product product = null;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(Basket.PRODUCT_CAN_T_BE_NULL);

        new Basket(product);
    }

    @Test
    public void shouldBasketContainProductConstructor() {
        Product product = new Product();

        Basket basket = new Basket(product);
        List<Product> content = basket.getContent();

        assertTrue(content.contains(product));
    }

    @Test
    public void shouldBasketExceptionMessageWhenIsBuildWithNullList() {
        ArrayList<Product> products = null;
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(Basket.PRODUCTS_CAN_T_BE_NULL);

        new Basket(products);
    }

    @Test
    public void shouldBasketContainProductsConstructor() {
        List<Product> products = new ArrayList<>(1);
        products.add(new Product());

        Basket basket = new Basket(products);

        assertEquals(products, basket.getContent());
    }

    @Test
    public void shouldAddProductsInBasket() {
        Product product = new Product();

        Basket basket = new Basket();
        basket.addProduct(product);

        assertTrue(basket.getContent().contains(product));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBasketIfAddNullObjectThrowException() {
        Basket basket = new Basket();
        Product product = null;

        basket.addProduct(product);
    }

    @Test
    public void shouldBasketThrowMessageExceptionIfAddNullProduct() {
        Product product = null;
        Basket basket = new Basket();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(Basket.PRODUCT_CAN_T_BE_NULL);

        basket.addProduct(product);
    }

    @Test
    public void shouldBasketRemoveProductFromContent() {
        Product product = new Product();
        Basket basket = new Basket(product);

        basket.removeProduct(product);

        assertTrue(basket.getContent().isEmpty());
    }

    @Test
    public void shouldEmptyBasketThrowUnsupportedOperationExceptionIfRemovedNotContainedProduct() {
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage(Basket.BASKET_IS_EMPTY_THIS_OPERATION_CAN_T_BE_PERFORMED);
        Basket basket = new Basket();

        basket.removeProduct(new Product());
    }

    @Test
    public void shouldBasketThrowUnsupportedOperationExceptionIfRemovedNotContainedProduct() {
        exception.expect(UnsupportedOperationException.class);
        exception.expectMessage(Basket.BASKET_DOESN_T_CONTAINS_THIS_PRODUCT_THIS_OPERATION_CAN_T_BE_PERFORMED);

        Product product = new Product(1, 1, Product.Type.HOT);
        Basket basket = new Basket(product);

        basket.removeProduct(new Product());
    }

    @Test
    public void shouldBasketClearAllContent() {
        Basket basket = new Basket();
        basket.addProduct(new Product());

        basket.clearContent();

        assertTrue(basket.getContent().isEmpty());
    }
}
