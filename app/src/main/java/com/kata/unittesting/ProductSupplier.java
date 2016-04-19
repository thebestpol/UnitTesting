package com.kata.unittesting;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductSupplier
 */
public class ProductSupplier {

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

    public static Product getCoffee() {
        return new Product(2, 1.25, Product.Type.HOT);
    }

    public static List<Product> getCoffees(int quantity) {
        List<Product> coffees = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            coffees.add(new Product(2, 1.25, Product.Type.HOT));
        }

        return coffees;
    }

    public static Product getChips() {
        return new Product(3, 1.75, Product.Type.COLD);
    }

    public static List<Product> getChips(int quantity) {
        List<Product> chips = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            chips.add(new Product(3, 1.75, Product.Type.COLD));
        }

        return chips;
    }

    public static Product getSandwich() {
        return new Product(4, 2.25, Product.Type.COLD);
    }

    public static List<Product> getSandwiches(int quantity) {
        List<Product> sandwiches = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            sandwiches.add(new Product(4, 2.25, Product.Type.COLD));
        }

        return sandwiches;
    }

    public static Product getPizza() {
        return new Product(5, 4.5, Product.Type.HOT);
    }

    public static List getPizzas(int quantity) {
        List<Product> pizzas = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            pizzas.add(new Product(5, 4.5, Product.Type.HOT));
        }

        return pizzas;
    }
}
