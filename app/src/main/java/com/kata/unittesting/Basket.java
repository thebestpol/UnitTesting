package com.kata.unittesting;

import java.util.ArrayList;
import java.util.List;

/**
 * To put in practice our developer skills, we are going to solve a real problem not more complex than a JUnit Kata as String
 * Calculator, Converter, FeezBuzz, etc
 * <p>
 * <b>THE SHOPPING BASKET</b>
 * <p>
 * <u>Context:</u> A catering application has an operative where a costumer makes selections of products from a supplier menu.
 * These selected products are added in a shopping basket to be processed to obtain the sale data to make a deal with the seller.
 * This process is called <b>Sales Operative</b>.
 * <p>
 * <u>The problem:</u>
 * Create wrapper class to put the collection of selected {@link com.kata.unittesting.Product} and think a way to process it.
 * <p>
 * First steps:
 * <ul>
 * <li>Make the basket able to handle interaction with the products, adding, removing or canceling.</li>
 * <li>Create a representation of the shopping basket information, g.e Ticket.</li>
 * <li>Implement a way to process the shopping basket information to get the sale data.</li>
 * </ul>
 * <p>
 * Adding complexity: Apply to the sale data <b>PROMOTIONS:</b>
 * <ul>
 * <li><u>Same product promotion:</u> The costumer should have been selected three of the same product to be applied, and it will
 * pay only two of them </li>
 * <li><u>Fixed price promotion:</u></li>
 * <ul><li>Party pizza: The costumer should selected two beers and one pizza and the price will be 7 euros</li></ul>
 * <ul><li>Sad party: The costumer should selected four colas and two chips and the price will be 5 euros, no beer no
 * party</li></ul>
 * </ul>
 */
public class Basket {

    public static final String PRODUCT_CAN_T_BE_NULL = "Product can't be null";

    public static final String PRODUCTS_CAN_T_BE_NULL = "Products can't be null";

    public static final String BASKET_IS_EMPTY_THIS_OPERATION_CAN_T_BE_PERFORMED
            = "Basket is empty, this operation can't be performed";

    public static final String BASKET_DOESN_T_CONTAINS_THIS_PRODUCT_THIS_OPERATION_CAN_T_BE_PERFORMED
            = "Basket doesn't contains this product, this operation can't be performed";

    private List<Product> content = new ArrayList<>();

    public Basket() {

    }

    public Basket(Product product) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException(PRODUCT_CAN_T_BE_NULL);
        }
        content.add(product);
    }

    public Basket(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException(PRODUCTS_CAN_T_BE_NULL);
        }
        content.addAll(products);
    }

    public List<Product> getContent() {
        return content;
    }

    public void addProduct(Product product) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException(PRODUCT_CAN_T_BE_NULL);
        }
        content.add(product);
    }

    public void removeProduct(Product product) throws UnsupportedOperationException {
        boolean isRemoved = content.remove(product);
        if (!isRemoved) {
            if (content.isEmpty()) {
                throw new UnsupportedOperationException(BASKET_IS_EMPTY_THIS_OPERATION_CAN_T_BE_PERFORMED);
            } else {
                throw new UnsupportedOperationException(BASKET_DOESN_T_CONTAINS_THIS_PRODUCT_THIS_OPERATION_CAN_T_BE_PERFORMED);
            }
        }
    }

    public void clearContent() {
        content = new ArrayList<>();
    }
}
