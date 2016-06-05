package tddpotter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by rodrigonc on 05/06/16.
 */
public class Cart {
    private int bookPrice;

    private Integer[] books = new Integer[]{};
    private double[] discounts = {0, 1, 0.95, 0.90, 0.80, 0.75};
    private Integer[] sameBooks = new Integer[]{0, 0, 0, 0, 0};

    public Cart() {
        this.bookPrice = 8;
    }

    public double calculatePrice() {
        double result = 0;
        int sumOfBooks = Array.getLength(books);
        int sameBooksSize = Array.getLength(sameBooks);

        while (sumOfBooks > 0) {
            int diffCount = 0;

            for (int i = 0; i < sameBooksSize; i++) {
                if (sameBooks[i] > 0) {
                    diffCount++;
                    sameBooks[i]--;
                }
            }

            sumOfBooks -= diffCount;
            result += diffCount * bookPrice * discounts[diffCount];
        }

        return result;
    }

    public void addBooks(Integer[] books) {
        this.books = books;
        for (int i = 0; i < Array.getLength(this.books); i += 1) {
            this.sameBooks[this.books[i]] += 1;
        }
    }
}
