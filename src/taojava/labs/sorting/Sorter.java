package taojava.labs.sorting;

import java.util.Comparator;

/**
 * Objects that know how to sort.
 *
 * @author Samuel A. Rebelsky
 * @author CSC 207 2013F
 */
public interface Sorter<T>
{
  /**
   * Sort an array in place.
   *
   * @param vals, an array to sort.
   * @param order, the order by which to sort the values.
   * @return
   *    The same array, now sorted.
   * @pre
   *    order can be applied to any two values in vals.
   * @pre
   *    VALS = vals.
   * @post
   *    vals is a permutation of VALS.
   * @post
   *    For all i, 0 < i < vals.length,
   *      order.compare(vals[i-1], vals[i]) <= 0
   */
  public T[] sorti(T[] values, Comparator<T> order);

  /**
   * Sort an array out of place.
   *
   * @param vals, an array to sort.
   * @param order, the order by which to sort the values.
   * @return sorted, an array.
   * @pre
   *    order can be applied to any two values in vals.
   * @post
   *    vals is unchanged.
   * @post
   *    sorted is a permutation of vals.
   * @post
   *    For all i, 0 < i < sorted.length,
   *      order.compare(sorted[i-1], sorted[i]) <= 0
   */
  public T[] sort(T[] values, Comparator<T> order);
} // interface Sorter
