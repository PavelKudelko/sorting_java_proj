package src.utils;

import java.util.function.Function;

public class SortPerformance {
    public static void runSort(String sortName, Function<Integer[], Integer> sortFunction) {
        // first column width should be 32 which is 8 tabs for better formatting
        int firstColumnWidth = 32;
        // ensure that first column will be exactly 32 chars
        String sortTitleComp = sortName + ", comparisons";
        String sortTitleToPrintComparisons = sortTitleComp + " ".repeat(firstColumnWidth - sortTitleComp.length());

        System.out.print(sortTitleToPrintComparisons);
        for (int size = 1000; size <= 10000; size += 1000) {
            Integer[] randomSetOfNums = RandomArray.generateRandomArray(size);
            // Measure performance and time
            int comparisons = measureSortPerformance(randomSetOfNums, sortFunction, true);
            System.out.printf("%-14d", comparisons);
        }
        System.out.println();
        // ensure first column will be 32 chars
        String sortTitleMs = sortName + ", ms";
        String sortTitleToPrintMs = sortTitleMs + " ".repeat(firstColumnWidth - sortTitleMs.length());
        System.out.print(sortTitleToPrintMs);
        for (int size = 1000; size <= 10000; size += 1000) {
            Integer[] randomSetOfNums = RandomArray.generateRandomArray(size);
            // Only print the time in ms
            measureSortPerformance(randomSetOfNums, sortFunction, false);
        }
        System.out.println();
    }
    // bool flag added to prevent running same test twice
    private static int measureSortPerformance(Integer[] array, Function<Integer[],
            Integer> sortFunction, boolean printComparisons) {
        long startTime = System.currentTimeMillis();
        int comparisons = sortFunction.apply(array.clone());
        long endTime = System.currentTimeMillis();
        // Print either time or comparisons based on the flag
        if (printComparisons) {
            return comparisons;
        } else {
            System.out.printf("%-14d", (endTime - startTime));
        }
        return 0;
    }
}

