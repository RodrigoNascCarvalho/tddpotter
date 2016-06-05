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
}