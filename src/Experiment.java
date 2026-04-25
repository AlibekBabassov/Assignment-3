import java.util.Arrays;

public class Experiment {
    private final Sorter sorter;
    private final Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }


    // Measures the time in nanoseconds to sort a copy of the given array.
    // @param arr  the array to sort (a copy is made to preserve original)
    // @param type "bubble" for Bubble Sort, "merge" for Merge Sort
    // @return elapsed time in nanoseconds

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length); // Don't modify the original
        long start = System.nanoTime();

        if (type.equalsIgnoreCase("bubble")) {
            sorter.basicSort(copy);
        } else if (type.equalsIgnoreCase("merge")) {
            sorter.advancedSort(copy);
        } else {
            System.out.println("Unknown sort type: " + type);
        }

        long end = System.nanoTime();
        return end - start;
    }

    // Measures the time (in nanoseconds) to search for a target in the array.
    // @param arr    the array to search
    // @param target the value to look for
    // @return elapsed time in nanoseconds

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }


    // Runs the full suite of experiments:
    // Three array sizes: small (10), medium (100), large (1000)
    // Two input types: random and sorted
    // Both sorting algorithms and linear search measured for each

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        String[] sizeLabels = {"Small (10)", "Medium (100)", "Large (1000)"};

        System.out.println("ALGORITHM PERFORMANCE EXPERIMENTS");

        for (int s = 0; s < sizes.length; s++) {
            int size = sizes[s];
            System.out.println("\nArray Size: " + sizeLabels[s]);

            // Random array
            int[] randomArr = sorter.generateRandomArray(size);

            // Pick a target: sometimes in array, sometimes not
            int target = (size > 0) ? randomArr[size / 2] : 42;

            System.out.println("\n[Input type: random]");

            if (size <= 10) {
                System.out.print("Array: ");
                sorter.printArray(randomArr);
            }

            long bubbleRandom = measureSortTime(randomArr, "bubble");
            long mergeRandom  = measureSortTime(randomArr, "merge");
            long searchRandom = measureSearchTime(randomArr, target);

            System.out.printf("Bubble Sort Time : %,d ns%n", bubbleRandom);
            System.out.printf("Merge Sort Time  : %,d ns%n", mergeRandom);
            System.out.printf("Linear Search    : %,d ns  (target=%d, index=%d)%n", searchRandom, target, searcher.search(randomArr, target));

            // Sorted array
            int[] sortedArr = Arrays.copyOf(randomArr, randomArr.length);
            Arrays.sort(sortedArr); // Use Java built-in to create a clean sorted baseline

            System.out.println("\n[Input type: sorted]");

            if (size <= 10) {
                System.out.print("Array: ");
                sorter.printArray(sortedArr);
            }

            long bubbleSorted = measureSortTime(sortedArr, "bubble");
            long mergeSorted = measureSortTime(sortedArr, "merge");
            long searchSorted = measureSearchTime(sortedArr, target);

            System.out.printf("Bubble Sort Time : %,d ns%n", bubbleSorted);
            System.out.printf("Merge Sort Time  : %,d ns%n", mergeSorted);
            System.out.printf("Linear Search    : %,d ns  (target=%d, index=%d)%n", searchSorted, target, searcher.search(sortedArr, target));

            // Comparison summary
            System.out.println("\nComparison Summary:");
            System.out.printf("Bubble Sort  — Random: %,d ns  |  Sorted: %,d ns%n", bubbleRandom, bubbleSorted);
            System.out.printf("Merge Sort   — Random: %,d ns  |  Sorted: %,d ns%n", mergeRandom, mergeSorted);
            System.out.printf("Linear Search— Random: %,d ns  |  Sorted: %,d ns%n", searchRandom, searchSorted);
            String fasterSort = (bubbleRandom < mergeRandom) ? "Bubble Sort" : "Merge Sort";
            System.out.println("Faster sort on random array: " + fasterSort);
        }

        System.out.println("EXPERIMENTS COMPLETE\n");
    }
}
