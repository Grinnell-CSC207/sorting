package edu.grinnell.csc207.sorting;

/**
 * A quick experiment with the selection sorter.
 *
 * @author Samuel A. Rebelsky
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
