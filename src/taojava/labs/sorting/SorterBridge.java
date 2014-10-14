package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A bridge between the two types of array sorters.  If you implement one 
 * of the two array-based sorting routines, this automatically gives you 
 * the other.
 *
 * Warning!  Do not try to use this directly.  The two implementations
 * here are mutually recursive.
 * 
 * @author Samuel A. Rebelsky
 */
public class SorterBridge<T>
    implements Sorter<T>
{
  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    // Sort
    T[] sorted = sort(vals, order);
    // And copy back to the original array
    System.arraycopy(sorted, 0, vals, 0, vals.length);
    // We're done
    return vals;
  } // sorti(T[], Comparator<T>)

  @Override
  public T[] sort(T[] values, Comparator<T> order)
  {
    return sorti(values.clone(), order);
  } // sort(T[], Comparator<T>)
} // SorterBridge<T>
