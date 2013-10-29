package edu.grinnell.csc207.sorting;

/**
 * A quick experiment with the built-in sorter.
 */
public class BuiltinSortExpt {

    /**
     * Run the experiments.
     */
    public static void main(String[] args) {
        Utils.iExperiments(new BuiltinSorter<Integer>());
        Utils.sExperiments(new BuiltinSorter<String>());
    } // main(String[])
} // class BuiltinSortExpt
