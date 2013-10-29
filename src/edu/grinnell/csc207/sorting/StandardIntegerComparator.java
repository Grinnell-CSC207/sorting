package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A standard comparator for integers.  Note that this is a singleton
 * class - you only ever need one copy of it.  Obtain the one copy
 * with StandardIntegerComparator.comparator.
 */
public class StandardIntegerComparator implements Comparator<Integer> {
    /**
     * The one copy.
     */
    public static StandardIntegerComparator comparator = 
            new StandardIntegerComparator();

    /**
     * Build a new comparator.  We make this private to keep the class
     * a singleton.
     */
    private StandardIntegerComparator() {
    } // StandardIntegerComparator()

    @Override
    public int compare(Integer x, Integer y) {
         // The "clever" way to implement this is 
         //   return x-y;
         // Unfortunately, that can lead to overflow or underflow.
         if (x < y) { 
             return -1;
         } else if (x == y) {
             return 0;
         } else {
             return 1;
         } // if x > y
    } // compare(Integer, Integer)
} // StandardIntegerComparator
