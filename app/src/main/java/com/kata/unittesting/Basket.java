package com.kata.unittesting;

/**
 * To put in practice our developer skills, we are going to solve a real problem not more complex than a JUnit Kata as String
 * Calculator, Converter, FeezBuzz, etc
 * <p/>
 * <b>THE SHOPPING BASKET</b>
 * <p/>
 * <u>Context:</u> A catering application has an operative where a costumer makes selections of products from a supplier menu.
 * This selected products are added in a shopping basket to be processed to obtain the sale data to make a deal with the seller.
 * This process is called <b>Sales Operative</b>.
 * <p/>
 * <u>The problem:</u>
 * Create wrapper class to put the collection of selected {@link com.kata.unittesting.Product} and think a way to process it.
 * <p/>
 * First steps:
 * <ul>
 * <li>Make the basket able to handle interaction with the products, adding, removing or canceling.</li>
 * <li>Create a representation of the shopping basket information, g.e Ticket.</li>
 * <li>Implement a way to process the shopping basket information to get the sale data.</li>
 * </ul>
 * <p/>
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
}
