package com.kata.unittesting.promotion;

import com.kata.unittesting.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to apply promotions
 */
public abstract class PromotionApplicator {
    List<Product> products;

    public PromotionApplicator(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public abstract boolean process();

    public abstract double getPromotionAmount();

    public List<Product> getProducts() {
        return products;
    }

    protected void removeProducts(Product productToRemove, int quantityToRemove) {
        for (int i = 0; i < quantityToRemove; i++) {
            products.remove(productToRemove);
        }
    }
}
