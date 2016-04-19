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


    private List<Product> isProductList() {
        return new ArrayList<>();
    }
}
