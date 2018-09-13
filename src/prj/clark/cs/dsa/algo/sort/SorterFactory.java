package prj.clark.cs.dsa.algo.sort;

import prj.clark.cs.dsa.algo.sort.insert.InsertionSort;
import prj.clark.cs.dsa.algo.sort.merge.MergeSort;
import prj.clark.cs.dsa.algo.sort.quick.QuickSort;

public class SorterFactory {

    private SorterFactory() {}

    public static Sorter getSorter(String name) {
        switch (name) {
            case "merge": return new MergeSort();
            case "quick": return new QuickSort();
            case "insert": return new InsertionSort();
            default: throw new IllegalArgumentException(name + " is not a valid sorter.");
        }
    }
}
