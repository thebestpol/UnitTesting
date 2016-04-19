package com.kata.unittesting;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductSupplier
 */
public class ProductSupplier {

    public static final Product COFFEE = new Product(2, 1.25, Product.Type.HOT);

    public static final Product CHIPS = new Product(3, 1.75, Product.Type.COLD);

    public static final Product SANDWICH = new Product(4, 2.25, Product.Type.COLD);

    public static final Product PIZZA = new Product(5, 4.5, Product.Type.HOT);

    public static Product getCola() {
        return new Product(0, 1.5, Product.Type.COLD);
    }

    public static List<Product> getColas(int quantity) {
        List<Product> colas = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            colas.add(new Product(0, 1.5, Product.Type.COLD));
        }

        return colas;
    }

    public static Product getBeer() {
        return new Product(1, 2, Product.Type.COLD);
    }

    public static List<Product> getBeers(int quantity) {
        List<Product> beers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            beers.add(new Product(0, 2, Product.Type.COLD));
        }

        return beers;
    }
}
