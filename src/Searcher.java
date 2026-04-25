public class Searcher {
    public int search(int[] arr, int target) {
        // Iterate through every element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found — return its index
            }
        }
        return -1; // Target not found
    }
}
