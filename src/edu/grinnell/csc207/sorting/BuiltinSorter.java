package edu.grinnell.csc207.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using the built in sorter.
 */
public class BuiltinSorter<T> extends SorterBridge<T> {

   @Override
   public T[] sorti(T[] vals, Comparator<T> order) {
       Arrays.sort(vals, order);
       return vals;
   } // sorti(T[], Comparator<T>)
} // BuiltInSorter<T>
