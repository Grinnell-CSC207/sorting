package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using selection sort.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class SelectionSorter<T>
    extends SorterBridge<T>
{
  /**
   * Sort vals using selection sort.  See Sorter<T> for more details.
   */
  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    // Invariant:
    //   +-----------------+------------------+
    //   | sorted, smaller | unsorted, larger |
    //   +-----------------+------------------+
    //   |                 |                  |
    //   0                 i                 vals.length
    // That is,
    //   I1(i) / the left is sorted
    //     For all j, 0 <= j < i-1, 
    //       order.compare(vals[j], vals[j+1]) <= 0
    //   I2(i) / left precedes right
    //     For all j,k 0 <= j < i <= k < vals.length,
    //       order.compare(vals[j], vals[k]) <= 0
    for (int i = 0; i < vals.length; i++)
      {
        Utils.swap(vals, i, indexOfSmallest(vals, order, i, vals.length));
        // Analysis
        //   I1(i+1) holds because I1(i) holds and the new element at position
        //     i is form the unsorted subarray, and any element in the 
        //     unsorted subarray is at least as large as the values in 
        //     the sorted subarray
        //   I2(i+1) holds because I2(i) held and because the new element
        //     at position i is the smallest in the unsorted subarray.
        // Conclusion
        //   We can increment i and maintain the invariant
      } // for

    // At this point, i = vals.length, we therefore have
    //   +---------------------------------+
    //   | sorted, "smaller"               |
    //   +---------------------------------+
    //   |                                 |
    //   0                                 i,vals.length
    // And the whole array is sorted.
    return vals;
  } // sorti(T[], Comparator<T>)

  /**
   * Find the index of a smallest element in positions [lb..ub)
   * of values.
   *
   * @param
   *     values, the array into which we are inserting values.
   * @param
   *     order, the comparator used to determine order.
   * @param
   *     lb, the lower bound of the section to search.
   *     ub, the upper bound of the section to search.
   *     
   * @return
   *     is, the index of a smallest value
   *
   * @pre
   *     0 <= lb,ub <= values.length
   * @pre
   *     order can be compared to any pair of values in values.
   * @post
   *     lb <= i < ub
   * @post
   *     For all j, lb <= j < ub, order.compare(values[i], values[j]) <= 0.
   * @post
   *     values is not mutated
   */
  int indexOfSmallest(T[] vals, Comparator<T> order, int lb, int ub)
  {
    // STUB
    return lb;
  } // indexOfSmallest(T[], Comparator<T>, int, int)

} // SelectionSorter<T>
