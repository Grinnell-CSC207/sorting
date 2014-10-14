package taojava.labs.sorting;

import java.util.Comparator;

/**
 * A standard comparator for integers.  Note that this is a singleton
 * class - you only ever need one copy of it.  Obtain the one copy
 * with StandardIntegerComparator.comparator.
 *
 * @author Samuel A. Rebelsky
 */
public class StandardIntegerComparator
    implements Comparator<Integer>
{
  // +-------+-----------------------------------------------------------
  // | Notes |
  // +-------+

  /*

  1. A quick analysis of the implementation of compare.

  The traditional "clever" implementation is to use

      return x-y;

  Unfortunately, that strategy can lead to overflow or underflow.

  In Java 7, Integers implement Comparator and you can use

      return Integer.compare(x,y);

  Unfortunately, that's not supported in Java 6, and some people still 
  use Java 6.

  We could write a series of tests

      if (x < y)
        return -1;
      else if (x == y)
        return 0;
      else
        return 1;

  That's a good strategy.  However, it does not leverage existing
  code, and may violate some expectations for people who are used to
  using built-in comparators.

  Hence, our strategy is to box the values and use the compare method
  that Integers include because they implement Comparable.

  2. This class reminds me of why I like anonymous inner classes.

     */

  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one copy.
   */
  public static final StandardIntegerComparator COMPARATOR =
      new StandardIntegerComparator();

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new comparator.  We make this private to keep the class
   * a singleton.
   */
  private StandardIntegerComparator()
  {
  } // StandardIntegerComparator()

  // +--------------------+----------------------------------------------
  // | Comparator Methods |
  // +--------------------+

  @Override
  public int compare(Integer x, Integer y)
  {
    // I think this works on most platforms.
    return x.compareTo(y);
  } // compare(Integer, Integer)
} // StandardIntegerComparator
