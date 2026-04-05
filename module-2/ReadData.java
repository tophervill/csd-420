/*
 * Purpose:
 *      Read and display data from "datafile.dat".
 *      The file contains sets of five integers followed by five doubles.
 *      Continues reading until the end of the file is reached.
 */

import java.io.*;

public class ReadData {
    public static void main(String[] args) {

        String fileName = "VillarrealDataFile.dat";

        try {
            // Open file for reading
            FileInputStream fileInput = new FileInputStream(fileName);

            // Use buffering to improve read performance
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);

            // Allows reading primitive data types in binary format
            DataInputStream input = new DataInputStream(bufferedInput);

            System.out.println("Reading data from "  + fileName + "\n");
            int record = 1;

            // Continue reading until end of file is reached
            while (true) {
                System.out.println("Record " + record);
                System.out.println("Integers:");

                // Read integers in the same order they are written
                // (5 at a time)
                for (int i = 0; i < 5; i++) {
                    System.out.println(input.readInt());
                }

                System.out.println("\nDoubles:");

                // Read doubles in the same order they are written
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%.2f%n", input.readDouble());
                }

                System.out.println();
                record++;
            }

        } catch (EOFException e) {
            // Expected when reaching the end of the file
            System.out.println("No more data found. \nEnd of file reached.");

        } catch (IOException e) {
            // Handle file reading errors
            System.out.println("Error reading '" + fileName + "'.");
            e.printStackTrace();
        }
    }
}