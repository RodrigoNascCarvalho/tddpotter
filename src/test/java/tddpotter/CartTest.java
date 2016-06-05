package tddpotter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    private static final double DELTA = 1e-15;
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
}