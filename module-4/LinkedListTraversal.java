package module4;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Christopher Villarreal
 * Module 4 Assignment
 *
 * Purpose of this Program:
 *      This program stores integers in a LinkedList and compares the time
 *      required to traverse the list using two different approaches:
 *      1. Using an iterator
 *      2. Using the get(index) method
 *
 * Explanation of Program's Results:
 *      The results from the iterator approach is clearly a lot faster when traversing a LinkedList because it moves
 *      through the list one element at a time. Meanwhile, the index method approach takes longer because each call must
 *      search through the LinkedList to find the element at the specified position.
 *
 *      Thus, when the list contains 50,000 integers versus 500,000 integers, the time duration is noticeable. This
 *      shows that the get(index) method is inefficient for traversing a LinkedList, especially as the size increases.
 *
 */

public class LinkedListTraversal {

    public static void main(String[] args) {

        System.out.println("==== Beginning Test with 50,000 integers ====");
        // Test the program with 50,000 integers
        runTest(50000);

        System.out.println("\n==== Ending Test with 50,000 integers ====");

        System.out.println("\n==== Beginning Test with 500,000 integers ====\n");

        // Test the program with 500,000 integers
        runTest(500000);

        System.out.println("\n=== Ending Test with 500,000 integers ===");
    }

    /**
     * Creates a LinkedList of integers, verifies the data was stored correctly,
     * and compares traversal time using an iterator and the get(index) method.
     *
     * @param size the number of integers to store in the LinkedList
     */
    public static void runTest(int size) {

        // Create a LinkedList of Integer values
        LinkedList<Integer> numbers = new LinkedList<>();

        // Fill the LinkedList with integer values from 0 up to size - 1
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        // Ensures test will function correct
        if (numbers.size() != size) {
            System.out.println("Error: LinkedList size is incorrect.");
            return;
        }

        if (numbers.getFirst() != 0 || numbers.getLast() != size - 1) {
            System.out.println("Error: LinkedList values are incorrect.");
            return;
        }

        System.out.println("\tTesting LinkedList traversal with " + size + " integers.\n");

        // Time traversal using an iterator
        long iteratorStartTime = System.nanoTime();

        Iterator<Integer> iterator = numbers.iterator();
        long iteratorSum = 0;

        while (iterator.hasNext()) {
            iteratorSum += iterator.next();
        }

        long iteratorEndTime = System.nanoTime();
        long iteratorElapsedTime = iteratorEndTime - iteratorStartTime;
        double iteratorConvertedTime = iteratorElapsedTime / 1000000.0;

        // Time traversal using get(index)
        long getStartTime = System.nanoTime();

        long getSum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            getSum += numbers.get(i);
        }

        long getEndTime = System.nanoTime();
        long getElapsedTime = getEndTime - getStartTime;

        double getConvertedTime = getElapsedTime / 1000000.0;

        // Display results
        System.out.println("\tIterator traversal time: " + String.format("%.2f", iteratorConvertedTime) + " ms");
        System.out.println("\tget(index) traversal time: " + String.format("%.2f", getConvertedTime) + " ms");

        System.out.println();

        // Verify both traversal methods processed the same data
        if (iteratorSum == getSum) {
            System.out.println("\tTest passed: Both traversal methods produced the same result.");
        } else {
            System.out.println("\tTest failed: Traversal results do not match.");
        }
    }

}