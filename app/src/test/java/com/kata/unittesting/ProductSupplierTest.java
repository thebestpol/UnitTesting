package com.kata.unittesting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ProductSupplierTest
 */
public class ProductSupplierTest {

    private static final int DUMMY_COUNT = 0;

    private static final int MOCK_COUNT = 2;

    public static final String HOT_BEER_MESSAGE = "WHAT AN ASS THIS SUPPLIER, HOT BEERS DOESN'T PASS ANY KIND OF TEST";

    @Test
    public void shouldProductSupplierReturnProductWhenRequestCola() {
        Object requestedSupply = ProductSupplier.getCola();

        assertTrue(requestedSupply instanceof Product);
    }

    @Test
    public void shouldProductSupplierReturnListOfProductsWhenRequestColas() {
        List requestedSupplies = ProductSupplier.getColas(DUMMY_COUNT);

        assertEquals(isProductList(), requestedSupplies);
    }

    @Test
    public void shouldProductSupplierReturnRequestedColasQuantity() {
        List requestedSupplies = ProductSupplier.getColas(MOCK_COUNT);

        assertEquals(MOCK_COUNT, requestedSupplies.size());
    }

    @Test
    public void shouldProductSupplierReturnProductWhenRequestBeer() {
        Object requestedSupply = ProductSupplier.getBeer();

        assertTrue(requestedSupply instanceof Product);
    }

    @Test
    public void shouldProductSupplierReturnListOfProductsWhenRequestBeers() {
        List requestedSupplies = ProductSupplier.getBeers(DUMMY_COUNT);

        assertEquals(isProductList(), requestedSupplies);
    }

    @Test
    public void shouldProductSupplierReturnRequestedBeersQuantity() {
        List requestedSupplies = ProductSupplier.getBeers(MOCK_COUNT);

        assertEquals(MOCK_COUNT, requestedSupplies.size());
    }

    @Test
    public void shouldProductSupplierDeliveryBeerCold() {
        Product beer = ProductSupplier.getBeer();

        assertEquals(HOT_BEER_MESSAGE, Product.Type.COLD, beer.getType());
    }

    @Test
    public void shouldProductSupplierDeliveryAllBeersCold() {
        List<Product> beers = ProductSupplier.getBeers(MOCK_COUNT);
        for (Product beer : beers) {
            assertEquals(Product.Type.COLD, beer.getType());
        }
    }

    @Test
    public void shouldProductSupplierReturnProductWhenRequestCoffee() {
        Object requestedSupply = ProductSupplier.getCoffee();

        assertTrue(requestedSupply instanceof Product);
    }

    @Test
    public void shouldProductSupplierReturnListOfProductsWhenRequestCoffees() {
        List requestedSupplies = ProductSupplier.getCoffees(DUMMY_COUNT);

        assertEquals(isProductList(), requestedSupplies);
    }

    @Test
    public void shouldProductSupplierReturnRequestedCoffeesQuantity() {
        List requestedSupplies = ProductSupplier.getCoffees(MOCK_COUNT);

        assertEquals(MOCK_COUNT, requestedSupplies.size());
    }

    @Test
    public void shouldProductSupplierReturnProductWhenRequestChips() {
        Object requestedSupply = ProductSupplier.getChips();

        assertTrue(requestedSupply instanceof Product);
    }

    @Test
    public void shouldProductSupplierReturnListOfProductsWhenRequestChips() {
        List requestedSupplies = ProductSupplier.getChips(DUMMY_COUNT);

        assertEquals(isProductList(), requestedSupplies);
    }

    @Test
    public void shouldProductSupplierReturnRequestedChipsQuantity() {
        List requestedSupplies = ProductSupplier.getChips(MOCK_COUNT);

        assertEquals(MOCK_COUNT, requestedSupplies.size());
    }

    @Test
    public void shouldProductSupplierReturnProductWhenRequestSandwich() {
        Object requestedSupply = ProductSupplier.getSandwich();

        assertTrue(requestedSupply instanceof Product);
    }

    @Test
    public void shouldProductSupplierReturnListOfProductsWhenRequestSandwiches() {
        List requestedSupplies = ProductSupplier.getSandwiches(DUMMY_COUNT);

        assertEquals(isProductList(), requestedSupplies);
    }

    @Test
    public void shouldProductSupplierReturnRequestedSandwichesQuantity() {
        List requestedSupplies = ProductSupplier.getSandwiches(MOCK_COUNT);

        assertEquals(MOCK_COUNT, requestedSupplies.size());
    }

    @Test
    public void shouldProductSupplierReturnProductWhenRequestPizza() {
        Object requestedSupply = ProductSupplier.getPizza();

        assertTrue(requestedSupply instanceof Product);
    }

    @Test
    public void shouldProductSupplierReturnListOfProductsWhenRequestPizzas() {
        List requestedSupplies = ProductSupplier.getPizzas(DUMMY_COUNT);

        assertEquals(isProductList(), requestedSupplies);
    }

    @Test
    public void shouldProductSupplierReturnRequestedPizzasQuantity() {
        List requestedSupplies = ProductSupplier.getPizzas(MOCK_COUNT);

        assertEquals(MOCK_COUNT, requestedSupplies.size());
    }

    private List<Product> isProductList() {
        return new ArrayList<>();
    }
}
