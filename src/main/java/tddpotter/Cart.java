package tddpotter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by rodrigonc on 05/06/16.
 */
public class Cart {
    private int bookPrice;

    private Integer[] books = new Integer[]{};
    private double[] discounts = {0, 1, 0.95, 0.90, 0.80, 0.75};

    public Cart() {
        this.bookPrice = 8;
    }

    public double calculatePrice() {
        Set<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(books));
        int uniqueSize = Array.getLength(set.toArray());
        return discounts[uniqueSize] * uniqueSize * bookPrice;
    }

    public void addBooks(Integer[] books) {
        this.books = books;
    }


}
