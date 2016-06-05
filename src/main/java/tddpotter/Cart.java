package tddpotter;

import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * Created by rodrigonc on 05/06/16.
 */
public class Cart {
    private int bookPrice;
    private int[] bookList = {};

    public Cart() {
        this.bookPrice = 8;
    }

    public float calculatePrice() {
        return Array.getLength(bookList) * bookPrice;
    }

    public void addBooks(int[] bookList) {
        this.bookList = bookList;
    }
}
