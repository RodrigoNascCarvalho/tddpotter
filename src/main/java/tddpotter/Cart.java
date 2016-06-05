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
    private ArrayList<Integer[]> sets = new ArrayList<Integer[]>();

    public Cart() {
        this.bookPrice = 8;
    }

    public double calculatePrice() {
        double result = 0;

        buildBookSets();

        for (Integer[] set : sets) {
            int setSize = countBooks(set);
            result += bookPrice * discounts[setSize] * setSize;
        }

        return result;
    }

    public void buildBookSets() {
        int sumOfBooks = Array.getLength(books);
        int sameBooksSize = Array.getLength(sameBooks);

        while (sumOfBooks > 0) {
            Integer[] bookSet = new Integer[]{0, 0, 0, 0, 0};
            int diffCount = 0;

            for (int i = 0; i < sameBooksSize; i++) {
                if (sameBooks[i] > 0) {
                    bookSet[i]++;
                    diffCount++;
                    sameBooks[i]--;
                }
            }

            if (!sets.isEmpty()) {
                Integer[] lastSet = sets.get(sets.size() - 1);
                if (countBooks(bookSet) == 3 && countBooks(lastSet) == 5) {

                    int diffPos = diffPos(bookSet, lastSet);

                    if (diffPos != -1) {
                        bookSet[diffPos] = lastSet[diffPos];
                        lastSet[diffPos] = 0;
                        sets.remove(sets.size() - 1);
                        sets.add(lastSet);
                    }
                }
            }

            sumOfBooks -= diffCount;
            sets.add(bookSet);
        }
    }

    private int diffPos(Integer[] bookSet, Integer[] lastSet) {
        for (int i = 0; i < Array.getLength(bookSet); i++) {
            if (bookSet[i] != lastSet[i]) {
                return i;
            }
        }
        return -1;
    }

    private int countBooks(Integer[] set) {
        int count = 0;

        for (int i = 0; i < Array.getLength(set); i++) {
            if (set[i] == 1) {
                count++;
            }
        }
        return count;
    }


    public void addBooks(Integer[] books) {
        this.books = books;
        for (int i = 0; i < Array.getLength(this.books); i += 1) {
            this.sameBooks[this.books[i]] += 1;
        }
    }
}
