package tddpotter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by rodrigonc on 05/06/16.
 */
public class Cart {
    private int bookPrice;

    private Integer[] books = new Integer[]{};
    private double[] discounts = {0, 1, 0.95, 0.90, 0.80, 0.75};
    private Integer[] sameBooks = new Integer[]{0, 0, 0, 0, 0};
    private ArrayList<Integer> sets = new ArrayList<Integer>();

    public Cart() {
        this.bookPrice = 8;
    }

    public double calculatePrice() {
        double result = 0;

        buildBookSets();

        for (int set : sets) {
            result += bookPrice * discounts[set] * set;
        }

        return result;
    }

    public void buildBookSets() {
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

            if (!sets.isEmpty() && diffCount == 3 && sets.contains(5)) {
                int foundPos = sets.lastIndexOf(5);
                sets.remove(foundPos);
                sets.add(foundPos, 4);
                sets.add(diffCount + 1);
            } else {
                sets.add(diffCount);
            }

            sumOfBooks -= diffCount;
        }
    }

    public void addBooks(Integer[] books) {
        this.books = books;
        for (int i = 0; i < Array.getLength(this.books); i += 1) {
            this.sameBooks[this.books[i]] += 1;
        }
    }
}
