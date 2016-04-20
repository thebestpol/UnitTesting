package com.kata.unittesting;

import com.kata.unittesting.promotion.PartyPizzaPromotionApplicator;
import com.kata.unittesting.promotion.SadPartyPromotionApplicator;

import java.util.List;

/**
 * The objective of this class is process the shopping basket
 */
public class ShoppingCalculator {

    public static final String CAN_T_BE_CALCULATED_A_NULL_BASKET = "Can't be calculated a null basket";

    public static double processBasket(Basket basket) throws RuntimeException {
        if (basket == null) {
            throw new IllegalArgumentException(CAN_T_BE_CALCULATED_A_NULL_BASKET);
        }
        double amount = 0;

        SadPartyPromotionApplicator sadPartyPromotionApplicator = new SadPartyPromotionApplicator(basket.getContent());
        while (sadPartyPromotionApplicator.process()) {
            amount += sadPartyPromotionApplicator.getPromotionAmount();
        }

        PartyPizzaPromotionApplicator partyPizzaPromotionApplicator = new PartyPizzaPromotionApplicator(
                sadPartyPromotionApplicator.getProducts());
        while (partyPizzaPromotionApplicator.process()) {
            amount += partyPizzaPromotionApplicator.getPromotionAmount();
        }

        List<Product> shoppingContent = partyPizzaPromotionApplicator.getProducts();
        for (Product product : shoppingContent) {
            amount += product.getPrice();
        }

        return amount;
    }

}
