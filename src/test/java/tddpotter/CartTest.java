package tddpotter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    private static final double DELTA = 0.01;
    private Cart cart;

    @Before
    public void createNewCart() {
        cart = new Cart();
    }

    @Test
    public void testWithNoBook() {
        assertEquals(0, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithBook1() {
        cart.addBooks(new Integer[]{0});
        assertEquals(8, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithBook2() {
        cart.addBooks(new Integer[]{1});
        assertEquals(8, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithBook3() {
        cart.addBooks(new Integer[]{2});
        assertEquals(8, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithBook4() {
        cart.addBooks(new Integer[]{3});
        assertEquals(8, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithBook5() {
        cart.addBooks(new Integer[]{4});
        assertEquals(8, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithTwoDifferentBooks() {
        cart.addBooks(new Integer[]{0, 1});
        assertEquals(15.2, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithThreeDifferentBooks() {
        cart.addBooks(new Integer[]{0, 1, 2});
        assertEquals(21.6, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithFourDifferentBooks() {
        cart.addBooks(new Integer[]{0, 1, 2, 3});
        assertEquals(25.6, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithFiveDifferentBooks() {
        cart.addBooks(new Integer[]{0, 1, 2, 3, 4});
        assertEquals(30, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithTwoOfSameBook() {
        cart.addBooks(new Integer[]{0, 0});
        assertEquals(16, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testWithThreeOfSameBook() {
        cart.addBooks(new Integer[]{0, 0, 0});
        assertEquals(24, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testSeveralDiscounts1() {
        cart.addBooks(new Integer[]{0, 0, 1});
        assertEquals(8 + (8 * 2 * 0.95), cart.calculatePrice(), DELTA);
    }

    @Test
    public void testSeveralDiscounts2() {
        cart.addBooks(new Integer[]{0, 0, 1, 1});
        assertEquals(2 * (8 * 2 * 0.95), cart.calculatePrice(), DELTA);
    }

    @Test
    public void testSeveralDiscounts3() {
        cart.addBooks(new Integer[]{0, 0, 1, 2, 2, 3});
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), cart.calculatePrice(), DELTA);
    }

    @Test
    public void testSeveralDiscounts4() {
        cart.addBooks(new Integer[]{0, 1, 1, 2, 3, 4});
        assertEquals(8 + (8 * 5 * 0.75), cart.calculatePrice(), DELTA);
    }

    @Test
    public void testEdgeCases1() {
        cart.addBooks(new Integer[]{0, 0, 1, 1, 2, 2, 3, 4});
        assertEquals(51.2, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testEdgeCases2() {
        cart.addBooks(new Integer[]{0, 0, 0, 0, 0,
                                    1, 1, 1, 1, 1,
                                    2, 2, 2, 2,
                                    3, 3, 3, 3, 3,
                                    4, 4, 4, 4});
        assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), cart.calculatePrice(), DELTA);
    }

    @Test
    public void testEdgeCases3() {
        cart.addBooks(new Integer[]{0, 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 4});
        assertEquals(78.8, cart.calculatePrice(), DELTA);
    }

    @Test
    public void testEdgeCases4() {
        cart.addBooks(new Integer[]{0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4});
        assertEquals(100, cart.calculatePrice(), DELTA);
    }
}