package taojava.labs.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using the built in sorter.
 * 
 * @author Samuel A. Rebelsky
 */
public class BuiltinSorter<T>
    extends SorterBridge<T>
{

  @Override
  public T[] sorti(T[] vals, Comparator<T> order)
  {
    Arrays.sort(vals, order);
    return vals;
  } // sorti(T[], Comparator<T>)
} // BuiltInSorter<T>
