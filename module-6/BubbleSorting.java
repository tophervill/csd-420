import java.util.ArrayList;
import java.util.Comparator;

/*
 * Christopher Villarreal
 * Module 6 Assignment 2
 *
 * Purpose of this Program:
 *      The purpose of this program is to have two generic bubble sort methods.
 *      The first method will sort elements that use the Comparable interface.
 *      Meanwhile, the second method sorts elements using a Comparator object.
 *
 * Code References:
 *      - https://www.geeksforgeeks.org/java/java-string-compareto-method-with-examples/
 */

public class BubbleSorting {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        numbers.add(12);
        numbers.add(7);
        numbers.add(89);
        numbers.add(-72);
        numbers.add(101);

        System.out.println("Original Integer List:");
        System.out.println("\t" + numbers);

        bubbleSort(numbers);

        System.out.println("\nSorted Integer List using Comparable:");
        System.out.println("\t" + numbers);


        ArrayList<String> names = new ArrayList<>();
        names.add("Christopher");
        names.add("Alex");
        names.add("Jacob");
        names.add("Toby");
        names.add("Brandon");

        System.out.println("\nOriginal Name List:");
        System.out.println("\t" + names);

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        bubbleSort(names, lengthComparator);

        System.out.println("\nSorted Name List by Length using Comparator:");
        System.out.println("\t" + names);
    }

    /*
     * This generic method uses the Comparable interface to sort a list. It operates on objects that define their
     * own natural ordering by implementing the Comparable interface.
     */
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {

        for (int j = 1; j < list.size(); j++) {

            for (int i = 0; i < list.size() - j; i++) {

                if (list.get(i).compareTo(list.get(i + 1)) > 0) {

                    E temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
    }

    /*
     * This generic method uses the Comparator interface to sort a list.
     * Allows us to define custom sorting rules.
     */
    public static <E> void bubbleSort(ArrayList<E> list, Comparator<E> comparator) {

        for (int j = 1; j < list.size(); j++) {

            for (int i = 0; i < list.size() - j; i++) {

                if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {

                    E temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
    }
}