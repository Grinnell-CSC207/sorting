package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A standard comparator for strings.  Note that this is a singleton
 * class - you only ever need one copy of it.  Obtain the one copy
 * with StandardStringComparator.comparator.
 */
public class StandardStringComparator implements Comparator<String> {
    /**
     * The one copy.
     */
    public static StandardStringComparator comparator = 
            new StandardStringComparator();

    /**
     * Build a new comparator.  We make this private to keep the class
     * a singleton.
     */
    private StandardStringComparator() {
    } // StandardStringComparator()

    @Override
    public int compare(String x, String y) {
         return x.compareTo(y);
    } // compare(String, String)
} // StandardStringComparator
