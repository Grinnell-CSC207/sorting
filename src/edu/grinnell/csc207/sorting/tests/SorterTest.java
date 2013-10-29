package edu.grinnell.csc207.sorting.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class SorterTest {

    /**
     * Build all permutations of sorted and see if they sort
     * properly.
     */
    public static <T> void testAllPermutations(Sorter<T> sorter,
            comparator<T> order, T[] sorted)
    {
        testAllPermutationsKernel(sorter, order, sorted, sorted, sorted.length);
    } // testAllPermutations(Sorter<T>, Comparator<T>, T[])

    /**
     * For each permutation of the first n elements of values, test if
     * the sorted version of values is equal to sorted.
     */
    public static <T> void testAllPermutationsKernel(Sorter<T> sorter,
            comparator<T> order, T[] sorted, T[] values, int n) {
        // Base case: We're out of elements
        if (n <= 0) {
            T[] resorted = Sorter.sort(values, order);
            if (! resorted.equals(sorted)) {
                System.err.println(
                fail("sort(" + Arrays.toString(values) + ") => "
                        + Arrays.toString(resorted));
            } // if (! resorted.equals(sorted)
        } else {
            for (int i = 0; i < n; i++) {
                Experiments.swap(values, i, n-1);
                testAllPermutationsKernel(sorter, order, sorted, values, n-1);
                Experiments.swap(values, i, n-1);
            } // for
        } // recursive case, n > 0
    } // testAllPermutations

    @Test
    public void test() {
	fail("Not yet implemented");
    }

}
