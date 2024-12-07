package src.utils;

import java.util.Random;

public class Utils {
    // Generate a random array of integers
    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            // numbers from -100 to 99
            array[i] = random.nextInt(200) - 100;
        }
        return array;
    }
    // Print an array of integers
    public static void printArray(Integer[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
