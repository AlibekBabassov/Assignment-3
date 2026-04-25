import java.util.Arrays;

public class Main {
    public static void main() {
        //Instantiate classes
        Sorter sorter    = new Sorter();
        Searcher searcher  = new Searcher();
        Experiment experiment = new Experiment(sorter, searcher);

        // Quick demo on small array
        System.out.println("Sorting & Searching Algorithm Demo\n");

        // Generate arrays of different sizes
        int[] small  = sorter.generateRandomArray(10);
        int[] medium = sorter.generateRandomArray(100);
        int[] large  = sorter.generateRandomArray(1000);

        // Demo: Bubble Sort on small array
        System.out.println("Bubble Sort Demo (small array):");
        System.out.print("Before: ");
        sorter.printArray(small);

        int[] bubbleCopy = Arrays.copyOf(small, small.length);
        sorter.basicSort(bubbleCopy);
        System.out.print("After:  ");
        sorter.printArray(bubbleCopy);

        // Demo: Merge Sort on small array
        System.out.println("\nMerge Sort Demo (small array)");
        System.out.print("Before: ");
        sorter.printArray(small);

        int[] mergeCopy = Arrays.copyOf(small, small.length);
        sorter.advancedSort(mergeCopy);
        System.out.print("After:  ");
        sorter.printArray(mergeCopy);

        // Demo: Linear Search
        System.out.println("\nLinear Search Demo");
        int target = small[small.length / 2];
        int foundIdx = searcher.search(small, target);
        int missingIdx = searcher.search(small, -999);

        System.out.printf("Searching for %d in array -> found at index %d%n", target, foundIdx);
        System.out.printf("Searching for -999 -> index %d (not found)%n", missingIdx);

        // Full Performance Experiments
        System.out.println();
        experiment.runAllExperiments();

        // Array sizes summary
        System.out.println("Array sizes used in experiments:");
        System.out.println("small  → " + small.length  + " elements");
        System.out.println("medium → " + medium.length + " elements");
        System.out.println("large  → " + large.length  + " elements");
    }
}
