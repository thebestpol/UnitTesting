package com.kata.unittesting;

/**
 * ProductSupplier
 */
public class ProductSupplier {

    public static final Product COLA = new Product(0, 1.5, Product.Type.COLD);

    public static final Product BEER = new Product(1, 2, Product.Type.COLD);

    public static final Product COFFEE = new Product(2, 2, Product.Type.HOT);

    public static final Product CHIPS = new Product(3, 1.75, Product.Type.COLD);

    public static final Product SANDWICH = new Product(4, 2.25, Product.Type.COLD);

    public static final Product PIZZA = new Product(5, 4.5, Product.Type.HOT);
}
