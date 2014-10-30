package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using a slightly different version of Quicksort.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here.
 */
public class NewQuicksorter<T>
    extends SorterBridge<T>
{
  /**
   * Sort vals using Quicksort.  See the Sorter<T> interface
   * for additional details.
   */
  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    qsort(vals, order, 0, vals.length);
    return vals;
  } // sorti(T[], Comparator<T>)

  /**
   * Sort the elements in positions [lb..ub) using Quicksort.
   */
  public void qsort(T[] vals, Comparator<T> order, int lb, int ub)
  {
    // One element arrays are sorted.
    if (lb >= ub - 1)
      {
        return;
      }
    else
      {
        T pivot = selectPivot(vals, order, lb, ub);
        int[] bounds = partition(pivot, vals, order, lb, ub);
        qsort(vals, order, lb, bounds[0]);
        qsort(vals, order, bounds[1], ub);
      } // More than one element
  } // qsort(T[], Comparator<T>, int, int)

  /**
   * Select a pivot from within positions [lb..ub) of vals.
   */
  public T selectPivot(T[] vals, Comparator<T> order, int lb, int ub)
  {
    return vals[lb];
  } // selectPivot(T[], Comparator<T>, int, int)
  
  /**
   * Reorganize the elements in positions [lb..ub) of vals such that
   * elements smaller than the pivot appear to the left, elements
   * bigger than the pivot appear to the right of the pivot, and
   * copies of the pivot are in the middle.  Return a two-element
   * array that gives the lower bound (inclusive) and upper bound
   * (exclusive) of the section of the array that contains the equal
   * values.
   *
   * @param
   *    pivot, a value
   * @param
   *    values, an array.
   * @param
   *    order, a comparator.
   * @param
   *    lb, an integer.
   * @param
   *    ub, an integer.
   * @return
   *    mid, the index of the pivot.
   *
   * @pre
   *    order can be applied to any pair of elements in vals.
   * @pre
   *    0 <= lb < ub < values.length.
   * @post
   *    lb <= mid < ub
   * @post
   *    values[mid] == pivot, for some value pivot
   * @post
   *    For all i, lb <= i < mid, order.compare(values[i],pivot) <= 0
   *    For all i, mid < i < ub, order.compare(pivot, values[i]) < 0
   */
  int[] partition(T pivot, T[] vals, Comparator<T> order, int lb, int ub)
  {
    // STUB
    return new int[] { lb,ub };
  } // partition
} // NewQuicksorter<T>
