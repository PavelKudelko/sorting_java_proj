package src.menu;

import src.search.Searching;
import src.sort.Sorting;
import src.utils.Utils;

import java.util.Scanner;

public class Menu {
    // data for searches
    private final Integer[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            printMenu();
            // obtain user's choice (1 - 5 or q/Q)
            System.out.println("Your choice: ");
            choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    performLinearSearch(scanner);
                    break;
                case "2":
                    performBinarySearch(scanner);
                    break;
                case "3":
                    performN2Search();
                    break;
                case "4":
                    performLogNSearch();
                    break;
                case "5":
                    sortingPerformance();
                    break;
                case "q":
                case "Q":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (!choice.equalsIgnoreCase("q")); // exit loop if q pr Q
        scanner.close();
    }
    private void printMenu() {
        System.out.println("Menu of searching and Sorting testbed.");
        System.out.println();
        System.out.println("""
                1) Linear searching
                2) Binary searching
                3) O(n^2) type of sorting
                4) O(n*log(n)) type of sorting
                5) Sorting performance""");
        System.out.println();
        System.out.println("q/Q) Quit");
        System.out.println();
    }

    private void performLinearSearch(Scanner scanner) {
        System.out.println("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
        int valueToSearch = scanner.nextInt();
        scanner.nextLine();
        // bool for handling search
        boolean found = Searching.linearSearch(data, 0, data.length - 1, valueToSearch);
        if (found) {
            System.out.println("Found");
        }
        else {
            System.out.println("Not found");
        }
        // empty line for formatting
        System.out.println();
    }
    private void performBinarySearch(Scanner scanner) {
        System.out.println("In the list are values 0, ..., 9; which value would you like to search with binary search? ");
        int valueToSearch = scanner.nextInt();
        scanner.nextLine();
        // bool for handling search
        boolean found = Searching.linearSearch(data, 0, data.length - 1, valueToSearch);
        if (found) {
            System.out.println("Found");
        }
        else {
            System.out.println("Not found");
        }
        // empty line for formatting
        System.out.println();
    }
    private void performN2Search() {
        System.out.println("Data set before insertion sorting:");
        // generate set of 10 nums (from ./utils/Utils)
        Integer[] randomSetOfNums = Utils.generateRandomArray(10);
        Utils.printArray(randomSetOfNums);
        // empty line for formatting
        System.out.println();
        System.out.println("Data set after insertion sorting:");
        // sort with insertion sort
        Sorting.insertionSort(randomSetOfNums);
        Utils.printArray(randomSetOfNums);
        System.out.println();
    }
    private void performLogNSearch() {
        System.out.println("Data set before merge sorting:");
        // generate set of 10 nums (from ./utils/Utils)
        Integer[] randomSetOfNums = Utils.generateRandomArray(10);
        Utils.printArray(randomSetOfNums);
        // empty line for formatting
        System.out.println();
        System.out.println("Data set after merge sorting:");
        // sort with merge sort
        Sorting.mergeSort(randomSetOfNums);
        Utils.printArray(randomSetOfNums);
        System.out.println();
    }
    private void sortingPerformance() {
        System.out.println("not implemented yet");
    }
}
