package edu.grinnell.csc207.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

public class TestUtils {

    // +---------+---------------------------------------------------------
    // | Helpers |
    // +---------+

    /**
     * Test one permutation of sorted.
     */
    public static <T> void testOnePermutation(Sorter<T> sorter, 
	    Comparator<T> order, T[] sorted) {
	T[] values = sorted.clone();
	Utils.permute(values);
	T[] resorted = sorter.sort(values, order);
        if (! resorted.equals(sorted)) {
            fail("sort(" + Arrays.toString(values) + ") => "
                    + Arrays.toString(resorted));
        } // if sorting failed.
    } // testOnePermutation
    
    /**
     * Build all permutations of sorted and see if they sort
     * properly.
     */
    public static <T> void testAllPermutations(Sorter<T> sorter,
            Comparator<T> order, T[] sorted)
    {
        testAllPermutationsKernel(sorter, order, sorted, sorted, sorted.length);
    } // testAllPermutations(Sorter<T>, Comparator<T>, T[])

    /**
     * For each permutation of the first n elements of values, test if
     * the sorted version of values is equal to sorted.
     */
    public static <T> void testAllPermutationsKernel(Sorter<T> sorter,
            Comparator<T> order, T[] sorted, T[] values, int n) {
        // Base case: We're out of elements
        if (n <= 0) {
            T[] resorted = sorter.sort(values, order);
            if (! resorted.equals(sorted)) {
                fail("sort(" + Arrays.toString(values) + ") => "
                        + Arrays.toString(resorted));
            } // if (! resorted.equals(sorted)
        } else {
            for (int i = 0; i < n; i++) {
                Utils.swap(values, i, n-1);
                testAllPermutationsKernel(sorter, order, sorted, values, n-1);
                Utils.swap(values, i, n-1);
            } // for
        } // recursive case, n > 0
    } // testAllPermutations

    // +---------------+---------------------------------------------------
    // | Generic Tests |
    // +---------------+

    /**
     * Test all permutations of a simple array of integers.
     */
    public static <T> void test1(Sorter<Integer> sorter) {
        testAllPermutations(sorter, StandardIntegerComparator.comparator,
                new Integer[] { 0, 1, 1, 2, 3, 4, 4, 7, 9, 11, 13, 13 });
    } // test1
    
    /**
     * Test a bunch of random permutations.
     */
    public static <T> void test2(Sorter<Integer> sorter) {
	for (int i = 1; i < 20; i++) {
	    testOnePermutation(sorter, StandardIntegerComparator.comparator,
		    Utils.randomSortedInts(i * 20));
	}
    } // test2(Sorter<Integer>)

} // class TestUtils
