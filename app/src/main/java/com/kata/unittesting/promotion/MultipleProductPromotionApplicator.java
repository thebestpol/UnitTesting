package com.kata.unittesting.promotion;

import com.kata.unittesting.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MultipleProductPromotionApplicator
 */
public class MultipleProductPromotionApplicator extends PromotionApplicator {

    public static final int PROMOTION_REQUIRED_QUANTITY = 3;

    public static final int PROMOTION_PAY_QUANTITY = 3;

    private double amount;

    public MultipleProductPromotionApplicator(List<Product> products) {
        super(products);
    }

    @Override
    public boolean process() {
        Product promotionProduct = null;
        if (products.size() >= PROMOTION_REQUIRED_QUANTITY) {
            if (products.size() == PROMOTION_REQUIRED_QUANTITY) {
                Product product = products.get(0);
                if (hasRequiredProducts(product)) {
                    promotionProduct = product;
                }
            } else {
                List<Product> rejectedProducts = new ArrayList<>(products.size());
                for (Product product : products) {
                    if (!rejectedProducts.contains(product)) {
                        if (hasRequiredProducts(product)) {
                            promotionProduct = product;
                            break;
                        } else {
                            rejectedProducts.add(product);
                        }
                    }
                }
            }
        }

        processAmount(promotionProduct);
        boolean isApplied = promotionProduct != null;
        if (isApplied) {
            removeProducts(promotionProduct, PROMOTION_REQUIRED_QUANTITY);
        }
        return isApplied;
    }

    private boolean hasRequiredProducts(Product product) {
        return Collections.frequency(products, product) >= PROMOTION_REQUIRED_QUANTITY;
    }

    private void processAmount(Product product) {
        amount = product == null ? 0 : product.getPrice() * PROMOTION_PAY_QUANTITY;
    }

    @Override
    public double getPromotionAmount() {
        return amount;
    }
}
