package src.menu;

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
                    performLinearSearch();
                    break;
                case "2":
                    performBinarySearch();
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

    private void performLinearSearch() {
        System.out.println("not implemented yet");
    }
    private void performBinarySearch() {
        System.out.println("not implemented yet");
    }
    private void performN2Search() {
        System.out.println("not implemented yet");
    }
    private void performLogNSearch() {
        System.out.println("not implemented yet");
    }
    private void sortingPerformance() {
        System.out.println("not implemented yet");
    }
}
