/*
 * Purpose:
 * Generate arrays of five random integers and five random doubles,
 * then write them to "datafile.dat" using binary output.
 * If the file already exists, data will be appended.
 */

import java.io.*;
import java.util.Random;
import java.util.Arrays;

public class WriteData {
    public static void main(String[] args) {

        String fileName = "VillarrealDataFile.dat";
        Random random = new Random();

        // Create arrays to store values
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        try {
            FileOutputStream fileOutput = new FileOutputStream(fileName, true);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
            DataOutputStream output = new DataOutputStream(bufferedOutput);

            System.out.println("Generating integers:");
            // Fill integer array
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = random.nextInt(100); //Randomize up to 100
                System.out.println(intArray[i]);
            }

            System.out.println("\nGenerating doubles:");
            // Fill double array
            for (int i = 0; i < doubleArray.length; i++) {
                doubleArray[i] = random.nextDouble() * 100;
                System.out.printf("%.2f%n", doubleArray[i]);
            }

            // Write integer array to file
            for (int value : intArray) {
                output.writeInt(value);
            }

            // Write double array to file
            for (double value : doubleArray) {
                output.writeDouble(value);
            }

            output.close();

            System.out.println("\nData successfully written to " + fileName + ".");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}