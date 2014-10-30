package taojava.labs.sorting;

import java.io.PrintWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * A variety of utilities for working with sorting algorithms.  Most
 * are designed to help with testing or experiments.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
class Utils
{
  // +---------------+---------------------------------------------------
  // | Static Fields |
  // +---------------+

  /**
   * A random number generator for use in permutations and such.
   */
  static Random generator = new Random();

  // +----------------+--------------------------------------------------
  // | Static Methods |
  // +----------------+

  /** 
   * Merge the values in arrays a1 and a2 into a new array.
   * @return
   *    merged, an array
   *
   * @pre
   *    sorted(a1, order)
   * @pre
   *    sorted(a2, order)
   * @post
   *    sorted(merged, order).
   * @post
   *    merged is a permutation of the concatenation of a1 and a2.
   */
  public static <T> T[] merge(Comparator<T> order, T[] a1, T[] a2)
  {
    return merge(order, a1, 0, a1.length, a2, 0, a2.length);
  } // merge(Comparator<T>, T[], T[])

  /**
   * Merge the values in arrays a1 and a2 into an existing array.
   * @return
   *    merged, an array
   *
   * @pre
   *    sorted(a1, order)
   * @pre
   *    sorted(a2, order)
   * @pre
   *    merged.length >= a1.length + a2.length
   * @post
   *    sorted(merged, order).
   * @post
   *    merged is a permutation of the concatenation of a1 and a2.
   */
  public static <T> T[] merge(Comparator<T> order, T[] a1, T[] a2, T[] merged)
  {
    return merge(order, a1, 0, a1.length, a2, 0, a2.length, merged, 0,
                 a1.length + a2.length);
  } // merge(Comparator<T>, T{], T[], T[])

  /**
   * Merge the values in subarrays of a1 and a2 into a new array.
   * The subarray of a1 takes on indices lb1 (inclusive) to ub1 (exclusive).
   * The subarray of a2 takes on indices lb2 (inclusive) to ub2 (exclusive).
   *
   * @return
   *    merged, an array
   *
   * @pre
   *    0 <= lb1 <= ub1 <= a1.length.
   * @pre
   *    0 <= lb2 <= ub2 <= a2.length.
   * @pre
   *    sorted(a1, order, lb1, ub1).
   * @pre
   *    sorted(a2, order, lb2, ub2).
   * @post
   *    sorted(merged, order).
   * @post
   *    merged is a permutation of the concatenation of the given 
   *    subarrays of a1 and a2.
   */
  @SuppressWarnings({ "unchecked" })
  public static <T> T[] merge(Comparator<T> order, T[] a1, int lb1, int ub1,
                              T[] a2, int lb2, int ub2)
  {
    // Create the new array for the merged values.
    T[] result = (T[]) new Object[(ub1 - lb1) + (ub2 - lb2)];
    // And merge
    return merge(order, a1, lb1, ub1, a2, lb2, ub2, result, 0, result.length);
  } // merge(Comparator<T>, T[], int, int, T[], int, int)

  /**
   * Merge the values in subarrays of a1 and a2 into a subarray of an
   *   existing array.
   * The subarray of a1 takes on indices lb1 (inclusive) to ub1 (exclusive).
   * The subarray of a2 takes on indices lb2 (inclusive) to ub2 (exclusive).
   * The subarray of merged takes on indices lbm (inclusive) to 
   *   ubm (exclusive).
   *
   * @return
   *    merged, an array
   *
   * @pre
   *    0 <= lb1 <= ub1 <= a1.length.
   * @pre
   *    0 <= lb2 <= ub2 <= a2.length.
   * @pre
   *    0 <= lbm <= ubm <= merged.length
   * @pre
   *    (ub1 - lb1) + (ub2 - lb2) = (ubm - lbm)
   * @pre
   *    sorted(a1, order, lb1, ub1).
   * @pre
   *    sorted(a2, order, lb2, ub2).
   * @post
   *    sorted(merged, order, lbm, ubm).
   * @post
   *    The subarray of merged is a permutation of the concatenation 
   *    of the given subarrays of a1 and a2.
   */
  public static <T> T[] merge(Comparator<T> order, T[] a1, int lb1, int ub1,
                              T[] a2, int lb2, int ub2, T[] merged, int lbm,
                              int ubm)
  {
    // STUB
    return merged;
  } // merge(Comparator<T>, T[], int, int, T[], int, int)

  /**
   * "Randomly" permute an array in place.
   */
  public static <T> T[] permute(T[] values)
  {
    for (int i = 0; i < values.length; i++)
      {
        swap(values, i, generator.nextInt(values.length));
      } // for
    return values;
  } // permute(T)

  /**
   * Generate a "random" sorted array of integers of size n.
   */
  public static Integer[] randomSortedInts(int n)
  {
    if (n == 0)
      {
        return new Integer[0];
      }
    Integer[] values = new Integer[n];
    // Start with a negative number so that we have a mix
    values[0] = generator.nextInt(10) - n;
    // Add remaining values.  We use a random increment between
    // 0 and 3 so that there are some duplicates and some gaps.
    for (int i = 1; i < n; i++)
      {
        values[i] = values[i - 1] + generator.nextInt(4);
      } // for
    return values;
  } // randomSortedInts

  /**
   * Determine if elements l..(u-1) of an array are in sorted order.
   *
   * @param values, the array.
   * @param order, the comparator that determines the ordering.
   * @param l, an integer
   * @param u, an integer
   * @return true if the subarray is ordered, false otherwise
   * @pre order can be applied to any two values in the array.
   * @pre 0 <= l <= values.length
   * @pre 0 <= u <= values.length
   */
  public static <T> boolean
    sorted(T[] values, Comparator<T> order, int l, int u)
  {
    for (int i = u - 1; i > l; i--)
      {
        if (order.compare(values[i - 1], values[i]) > 0)
          return false;
      } // for
    // At this point, we've checked every pair.  It must be sorted
    return true;
  } // sorted

  /**
   * Determine if an array is sorted.
   *
   * @param values, the array.
   * @param order, the comparator that determines the ordering.
   * @return true if the subarray is ordered, false otherwise
   * @pre order can be applied to any two values in the array.
   */
  public static <T> boolean sorted(T[] values, Comparator<T> order)
  {
    return sorted(values, order, 0, values.length);
  } // sorted(T[], Comparator<T>)

  /**
   * Swap two elements in an array.
   *
   * @param values, the array
   * @param i, one of the indices
   * @param j, another index
   * @pre 0 <= i,j < values.length
   * @pre a = values[i]
   * @pre b = values[j]
   * @post values[i] = b
   * @post values[j] = a
   */
  public static <T> void swap(T[] values, int i, int j)
  {
    T tmp = values[i];
    values[i] = values[j];
    values[j] = tmp;
  } // swap(T[], int, int)

} // class Utils
