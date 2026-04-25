import java.util.Random;

public class Sorter {
    public void basicSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            // Each pass bubbles the largest remaining element to the end
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Early exit if no swaps occurred: array is already sorted
            if (!swapped) break;
        }
    }

    // MERGE SORT — public entry point
    // Divides the array in half recursively, sorts each half, then merges them.
    // Uses divide and conquer strategy.
    // Time Complexity: O(n log n) in all cases

    public void advancedSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    // Recursively splits the array and sorts each half.

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;   // Avoids integer overflow
            mergeSort(arr, left, mid);             // Sort left half
            mergeSort(arr, mid + 1, right);   // Sort right half
            merge(arr, left, mid, right);         // Merge the two sorted halves
        }
    }

    // Merges two sorted sub-arrays: arr[left..mid] and arr[mid+1..right]

    private void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Temporary arrays to hold each half
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        // Copy data into temp arrays
        for (int i = 0; i < leftSize; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < rightSize; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merge the two halves back into arr
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy any remaining elements
        while (i < leftSize)  arr[k++] = leftArr[i++];
        while (j < rightSize) arr[k++] = rightArr[j++];
    }

    // Prints all elements of an array on a single line.

    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Generates an array of the given size filled with random integers (0–9999).
    public int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }
}
