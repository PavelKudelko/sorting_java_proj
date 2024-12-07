package src.menu;

import src.search.Searching;
import src.sort.Sorting;
import src.utils.RandomArray;
import src.utils.SortPerformance;

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
            System.out.print("Your choice: ");
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
        // bad user input handling
        int valueToSearch = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
            if (scanner.hasNextInt()) {
                valueToSearch = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
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
        // bad user input handling
        int valueToSearch = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("In the list are values 0, ..., 9; which value would you like to search with binary search? ");
            if (scanner.hasNextInt()) {
                valueToSearch = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
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
        // generate set of 10 nums (from ./utils/RandomArray)
        Integer[] randomSetOfNums = RandomArray.generateRandomArray(10);
        RandomArray.printArray(randomSetOfNums);
        // empty line for formatting
        System.out.println();
        System.out.println("Data set after insertion sorting:");
        // sort with insertion sort
        Sorting.insertionSort(randomSetOfNums);
        RandomArray.printArray(randomSetOfNums);
        System.out.println();
    }
    private void performLogNSearch() {
        System.out.println("Data set before merge sorting:");
        // generate set of 10 nums (from ./utils/RandomArray)
        Integer[] randomSetOfNums = RandomArray.generateRandomArray(10);
        RandomArray.printArray(randomSetOfNums);
        // empty line for formatting
        System.out.println();
        System.out.println("Data set after merge sorting:");
        // sort with merge sort
        Sorting.mergeSort(randomSetOfNums);
        RandomArray.printArray(randomSetOfNums);
        System.out.println();
    }
    private void sortingPerformance() {
        System.out.println("Sorting performance:\n");

        // Print the header for array sizes
        // seven tabs = 32 chars
        System.out.print("\t".repeat(8));
        for (int size = 1000; size <= 10000; size += 1000) {
            System.out.printf("%-14d", size);
        }
        System.out.println();

        // Process sorting algorithms
        // Class::method is a method reference
        SortPerformance.runSort("Selection sort", Sorting::selectionSort);
        SortPerformance.runSort("Insertion sort", Sorting::insertionSort);
        SortPerformance.runSort("Bubble sort", Sorting::bubbleSort);
        SortPerformance.runSort("Merge sort", Sorting::mergeSort);
        SortPerformance.runSort("Quick sort", Sorting::quickSort);
        System.out.println();
    }
}
