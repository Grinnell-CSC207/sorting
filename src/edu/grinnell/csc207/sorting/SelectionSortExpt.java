package edu.grinnell.csc207.sorting;

/**
 * A quick experiment with the built-in sorter.
 */
public class SelectionSortExpt {

    /**
     * Run the experiments.
     */
    public static void main(String[] args) {
        Utils.iExperiments(new SelectionSorter<Integer>());
        Utils.sExperiments(new SelectionSorter<String>());
    } // main(String[])
} // class SelectionSortExpt
