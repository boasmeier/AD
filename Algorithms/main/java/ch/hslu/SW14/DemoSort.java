/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {Class description here}.
 *
 * @author Boas Meier
 * @version JDK 12.0.2
 */
public class DemoSort {

    private static final Logger LOG = LogManager.getLogger(DemoSort.class);

    public static void main(String[] args) {
        //speedTestInsertionSort3(50_000);
        //speedTestInsertionSort3(100_000);
        //speedTestSelectionSort(50_000);
        //speedTestSelectionSort(100_000);
        //speedTestBubbleSort2(50_000);
        //speedTestBubbleSort2(100_000);
        //speedTestInsertionSort4(40);
        //speedTestInsertionSort4(10_000);
        //speedTestInsertionSort4(10_000);
        //speedTestInsertionSort3(10_000);
        //speedTestInsertionSort3(10_000);
        //speedTestInsertionSort3(10_000);
        //speedTestQuickInsertionsort(10000000);
        //speedTestQuicksortInt(10000000);
        //speedTestInsertionSort3(100000);
        //speedTestInsertionSort4(100000);
        /*
        char[] array = Sort.randomChars(10);
        char[] array2 = array.clone();
        char[] array3 = array.clone();
        char[] array4 = array.clone();
        char[] array5 = array.clone();
        Demo.testQuicksort(array);
        Demo.testQuicksort(array2);
        Demo.testQuicksort(array3);
        Demo.testQuicksort(array4);
        Demo.testQuicksort(array5);
         */

        testShellSortRandom(100000);
        testInsertionSort3Random2(10000);
        //speedTestInsertionSort4(100000);
        speedTestQuicksortInt(100000);
        speedTestQuickInsertionsort(100000);
    }

    // Speed tests
    public static void speedTestInsertionSort3(int length) {
        testInsertionSort3Random(length);
        testInsertionSort3Reversed(length);
        testInsertionSort3Sorted(length);
    }

    public static void speedTestInsertionSort4(int length) {
        testInsertionSort4Random(length);
        //testInsertionSort4Reversed(length);
        //testInsertionSort4Sorted(length);
    }

    public static void speedTestSelectionSort(int length) {
        testSelectionSortRandom(length);
        testSelectionSortReversed(length);
        testSelectionSortSorted(length);
    }

    public static void speedTestBubbleSort2(int length) {
        testBubbleSort2Random(length);
        testBubbleSort2Reversed(length);
        testBubbleSort2Sorted(length);
    }

    public static void speedTestQuicksort(int length) {
        testQuicksortRandom(length);
        //testQuicksortReversed(length);
        //testQuicksortSorted(length);
    }

    public static void speedTestQuicksortInt(int length) {
        testQuicksortIntRandom(length);
        //testQuicksortIntReversed(length);
        //testQuicksortIntSorted(length);
    }

    public static void speedTestQuickInsertionsort(int length) {
        testQuickInsertionsortRandom(length);
        //testQuickInsertionsortReversed(length);
        //testQuickInsertionsortSorted(length);
    }

    // Insertion sort -----------------------------------------------------------------------
    public static void testInsertionSortReversed(int arraySize) {
        Integer[] array = Sort.reversedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSortSorted(int arraySize) {
        Integer[] array = Sort.sortedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSortRandom(int arraySize) {
        Integer[] array = Sort.randomInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort with " + arraySize + " random Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    // Insertion sort2 --------------------------------------------------------------------
    public static void testInsertionSort2Reversed(int arraySize) {
        Integer[] array = Sort.reversedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort2 with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort2(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSort2Sorted(int arraySize) {
        Integer[] array = Sort.sortedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort2 with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort2(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    // Insertion sort 3 -----------------------------------------------------------------------
    public static void testInsertionSort3Reversed(int arraySize) {
        Integer[] array = Sort.reversedInts(5);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort3 with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort3(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSort3Sorted(int arraySize) {
        Integer[] array = Sort.sortedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort3 with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort3(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSort3Random(int arraySize) {
        Integer[] array = Sort.randomInts(arraySize);
        Integer[] clone;
        long average = 0;
        int tests = 8;
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort3 with " + arraySize + " random Elements");
        for (int i = 0; i < tests; i++) {
            clone = array.clone();
            long start = System.currentTimeMillis();
            sort.insertionSort3(clone);
            long time = System.currentTimeMillis() - start;
            LOG.info(i + ". Duration: " + time);
            average += time;
        }
        LOG.info("Average: " + average / tests);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSort3Random2(int arraySize) {
        int[] array = Sort.randomInts2(arraySize);
        int[] clone;
        long average = 0;
        int tests = 8;
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort3 (not generic) with " + arraySize + " random Elements");
        for (int i = 0; i < tests; i++) {
            clone = array.clone();
            long start = System.currentTimeMillis();
            sort.insertionSort3(clone, 0, arraySize - 1);
            long time = System.currentTimeMillis() - start;
            LOG.info(i + ". Duration: " + time);
            average += time;
        }
        LOG.info("Average: " + average / tests);
        //LOG.info(Arrays.toString(array));
    }

    // Insertion sort 4 -----------------------------------------------------------------------
    public static void testInsertionSort4Reversed(int arraySize) {
        Integer[] array = Sort.reversedInts(5);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort4 with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort4(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSort4Sorted(int arraySize) {
        Integer[] array = Sort.sortedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort4 with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.insertionSort4(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testInsertionSort4Random(int arraySize) {
        Integer[] array = Sort.randomInts(arraySize);
        Integer[] clone;
        long average = 0;
        int tests = 8;
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Insertion-Sort4 with " + arraySize + " random Elements");
        for (int i = 0; i < tests; i++) {
            clone = array.clone();
            long start = System.currentTimeMillis();
            sort.insertionSort4(clone);
            long time = System.currentTimeMillis() - start;
            LOG.info(i + ". Duration: " + time);
            average += time;
        }
        LOG.info("Average: " + average / tests);
        //LOG.info(Arrays.toString(array));
    }

    // Selection sort -----------------------------------------------------------------------
    public static void testSelectionSortReversed(int arraySize) {
        Integer[] array = Sort.reversedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Selection-Sort with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.selectionSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testSelectionSortSorted(int arraySize) {
        Integer[] array = Sort.sortedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Selection-Sort with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.selectionSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testSelectionSortRandom(int arraySize) {
        Integer[] array = Sort.randomInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Selection-Sort with " + arraySize + " random Elements");
        long start = System.currentTimeMillis();
        sort.selectionSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    // Bubble sort -----------------------------------------------------------------------
    public static void testBubbleSortReversed(int arraySize) {
        Integer[] array = Sort.reversedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Bubble-Sort with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.bubbleSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testBubbleSortSorted(int arraySize) {
        Integer[] array = Sort.sortedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Bubble-Sort with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.bubbleSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testBubbleSortRandom(int arraySize) {
        Integer[] array = Sort.randomInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Bubble-Sort with " + arraySize + " random Elements");
        long start = System.currentTimeMillis();
        sort.bubbleSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    // Bubble sort 2 -----------------------------------------------------------------------
    public static void testBubbleSort2Reversed(int arraySize) {
        Integer[] array = Sort.reversedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Bubble-Sort 2 with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.bubbleSort2(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testBubbleSort2Sorted(int arraySize) {
        Integer[] array = Sort.sortedInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Bubble-Sort 2 with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.bubbleSort2(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testBubbleSort2Random(int arraySize) {
        Integer[] array = Sort.randomInts(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Bubble-Sort 2 with " + arraySize + " random Elements");
        long start = System.currentTimeMillis();
        sort.bubbleSort2(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    // Shellsort
    public static void testShellSortRandom(int arraySize) {
        int[] array = Sort.randomInts2(arraySize);
        int[] clone;
        long average = 0;
        int tests = 8;
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Shellsort with " + arraySize + " random Elements");
        for (int i = 0; i < tests; i++) {
            clone = array.clone();
            long start = System.currentTimeMillis();
            sort.shellSort(clone);
            long time = System.currentTimeMillis() - start;
            LOG.info(i + ". Duration: " + time);
            average += time;
        }
        LOG.info("Average: " + average / tests);
        //LOG.info(Arrays.toString(array));
    }

    // Quicksort char -----------------------------------------------------------------------
    public static void testQuicksortReversed(int arraySize) {
        char[] array = Sort.reversedChars(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Quicksort with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.quickSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testQuicksortSorted(int arraySize) {
        char[] array = Sort.sortedChars(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Quicksort with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.quickSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testQuicksortRandom(int arraySize) {
        char[] array = Sort.randomChars(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Quicksort with " + arraySize + " random Elements");
        long start = System.currentTimeMillis();
        sort.quickSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testQuicksort(char[] array) {
        //char[] array = Sort.randomChars(40);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Quicksort with " + array.length + " random Elements");
        long start = System.currentTimeMillis();
        sort.quickSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    // Quicksort int -----------------------------------------------------------------------
    public static void testQuicksortIntReversed(int arraySize) {
        int[] array = Sort.reversedInts2(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Quicksort with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.quickSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testQuicksortIntSorted(int arraySize) {
        int[] array = Sort.sortedInts2(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Quicksort with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.quickSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testQuicksortIntRandom(int arraySize) {
        int[] array = Sort.randomInts2(arraySize);
        int[] clone;
        long average = 0;
        int tests = 8;
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start Quicksort with " + arraySize + " random Elements");
        for (int i = 0; i < tests; i++) {
            clone = array.clone();
            long start = System.currentTimeMillis();
            sort.quickSort(clone);
            long time = System.currentTimeMillis() - start;
            LOG.info(i + ". Duration: " + time);
            average += time;
        }
        LOG.info("Average: " + average / tests);
        //LOG.info(Arrays.toString(array));
    }

    // QuickInsertionSort -----------------------------------------------------------------------
    public static void testQuickInsertionsortReversed(int arraySize) {
        int[] array = Sort.reversedInts2(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start QuickInsertionsort with " + arraySize + " reversed Elements");
        long start = System.currentTimeMillis();
        sort.quickInsertionSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testQuickInsertionsortSorted(int arraySize) {
        int[] array = Sort.sortedInts2(arraySize);
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start QuickInsertionsort with " + arraySize + " sorted Elements");
        long start = System.currentTimeMillis();
        sort.quickSort(array);
        long time = System.currentTimeMillis() - start;
        LOG.info("Duration: " + time);
        //LOG.info(Arrays.toString(array));
    }

    public static void testQuickInsertionsortRandom(int arraySize) {
        int[] array = Sort.randomInts2(arraySize);
        int[] clone;
        long average = 0;
        int tests = 8;
        //LOG.info(Arrays.toString(array));
        Sort<Integer> sort = new Sort<>();
        LOG.info("Start QuickInsertionsort with " + arraySize + " random Elements");
        for (int i = 0; i < tests; i++) {
            clone = array.clone();
            long start = System.currentTimeMillis();
            sort.quickInsertionSort(clone);
            long time = System.currentTimeMillis() - start;
            LOG.info(i + ". Duration: " + time);
            average += time;
        }
        LOG.info("Average: " + average / tests);
        //LOG.info(Arrays.toString(array));
    }
}
