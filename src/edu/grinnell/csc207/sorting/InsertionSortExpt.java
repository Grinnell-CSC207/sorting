package edu.grinnell.csc207.sorting;

/**
 * A quick experiment with the built-in sorter.
 */
public class InsertionSortExpt {

    /**
     * Run the experiments.
     */
    public static void main(String[] args) {
        Utils.iExperiments(new InsertionSorter<Integer>());
        Utils.sExperiments(new InsertionSorter<String>());
    } // main(String[])
} // class InsertionSortExpt
