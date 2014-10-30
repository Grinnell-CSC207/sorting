package taojava.labs.sorting;

/**
 * Objects that generate arrays.
 *
 * @author Samuel A. Rebelsky
 */
public interface ArrayBuilder<T>
{
  /**
   * Build an array of length len.
   *
   * @pre
   *   len >= 0
   */
  public T[] build(int len);
} // ArrayBuilder<T>
