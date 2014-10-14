package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using iterative merge sort.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here.
 */
public class IterativeMergeSorter<T>
    extends SorterBridge<T>
{
  /**
   * Sort vals using iterative merge sort. See the Sorter<T> interface for
   * additional details.
   */
  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    // STUB
    int size = 1;
    while (size < vals.length)
      {
        // Merge neighboring subarrays of size size
        // FILL IN!
        // The merged subarrays are now twice as large
        size *= 2;
      } // while
    return vals;
  } // sorti(T[], Comparator<T>)
} // IterativeMergeSorter<T>
