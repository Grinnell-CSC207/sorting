package taojava.labs.sorting;

/**
 * A quick experiment with the selection sorter.
 *
 * @author Samuel A. Rebelsky
 */
public class SelectionSortExpt
{
  /**
   * Run the experiments.
   */
  public static void main(String[] args)
  {
    ExptUtils.iExperiments(new SelectionSorter<Integer>());
    ExptUtils.sExperiments(new SelectionSorter<String>());
  } // main(String[])
} // class SelectionSortExpt
