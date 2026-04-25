Assignment-3:Sorting and Searching Algorithm Analysis
Name: Babassov Alibek
Group: IT-2503

A. Project Overview:

-Bubble Sort — a simple comparison-based algorithm

-Merge Sort — an efficient divide-and-conquer algorithm

-Linear Search — a straightforward sequential scan

The purpose of the experiment is to measure and compare real execution times across different array sizes and input types and to validate whether practical performance matches theoretical Big-O complexity.

B. Algorithm Descriptions:

1. Bubble Sort — O(n²) Bubble Sort works by repeatedly scanning the array and swapping adjacent elements that are out of order. Each full pass guarantees the largest unsorted element "bubbles up" to its correct position at the end. The process repeats until no swaps are needed.
2. Merge Sort — O(n log n) Merge Sort uses a divide-and-conquer strategy. It recursively splits the array in half until sub-arrays have one element, then merges them back together in sorted order. The merge step compares elements from two sorted halves and places them in order.
3. Linear Search — O(n) Linear Search scans the array element by element from left to right until it finds the target value or exhausts the array. It returns the index of the target, or -1 if not found.
   
C. Experimental Results:

Times measured in nanoseconds using System.nanoTime().

Small Array (10 elements)

Algorithm | Random Array | Sorted Array
Bubble Sort | ~2,500 ns | ~800 ns
Merge Sort | ~5,000 ns | ~4,200 ns
Linear Search | ~300 ns | ~250 ns

Medium Array (100 elements)

Algorithm | Random Array | Sorted Array
Bubble Sort | ~45,000 ns | ~3,500 ns
Merge Sort | ~18,000 ns | ~15,000 ns
Linear Search | ~1200 ns | ~800 ns

Large Array (1000 elements)

Algorithm | Random Array | Sorted Array
Bubble Sort | ~4,200,000 ns | ~25,000 ns
Merge Sort | ~180,000 ns | ~160,000 ns
Linear Search | ~8,000 ns | ~5,000 ns

D. Screenshots: 

Added✅

E. Reflection Section:

Working on this assignment gave me a concrete understanding of why algorithm choice matters far beyond theory. Seeing Bubble Sort take millions of nanoseconds on a 1000-element array while Merge Sort completed the same task in under 200,000 ns made the O(n²) vs O(n log n) distinction viscerally real. It was especially striking that Bubble Sort on a sorted array was faster than Merge Sort — a reminder that Big-O describes asymptotic growth, not absolute performance in every situation.

The main challenge was correctly implementing the merge step in Merge Sort. Managing the left and right temporary arrays and ensuring no elements were skipped required careful index tracking. I also learned the importance of copying arrays before sorting so that the original data remains intact for fair comparisons across algorithms. Overall, this project reinforced that theoretical complexity is a reliable guide, but real performance also depends on input structure, constants, and memory access patterns.
