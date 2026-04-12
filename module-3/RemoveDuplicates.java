package module3;

import java.util.ArrayList;
import java.util.Random;

/*
 * Christopher Villarreal
 * Module 3 Assignment
 * CSD420
 *
 * Purpose of this Program:
 *      This program creates an original ArrayList with 50 random integer values
 *      between 1 and 20. It then uses a generic static method named
 *      removeDuplicates() to create and return a new ArrayList containing
 *      only unique values from the original list.
 *
 */

public class RemoveDuplicates {

    public static void main(String[] args) {

        // Integer only ArrayList
        ArrayList<Integer> originalList = new ArrayList<>();

        // Create a Random object for generating random numbers
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        System.out.println("The contents for Original List are:");
        System.out.println(originalList);

        // Call the generic removeDuplicates method
        ArrayList<Integer> modifiedList = removeDuplicates(originalList);

        System.out.println("\nList After Removing Duplicates:");
        System.out.println(modifiedList);
    }

    /*
     * This generic static method creates and returns a new ArrayList
     * that does not add duplicates if the previous list had it.
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> modifiedList = new ArrayList<>();

        if (!list.isEmpty()) {

            for (E element : list) {

                // Checks if value exist, if not, add
                if (!modifiedList.contains(element)) {
                    modifiedList.add(element);
                }
            }

        } else {
            System.out.println("List is empty");
        }

        return modifiedList;
    }
}