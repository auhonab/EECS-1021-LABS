package eecs1021;
import java.lang.Math;
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        // Create a Scanner object from the System.in stream
        Scanner scanner = new Scanner(System.in);

        // Set the radix of the scanner to 2 (binary)
        scanner.useRadix(2);

        int runningSum = 0;

        while (true) {
            try {
                // Prompt the user to enter a binary number
                System.out.print("Enter a binary number: ");


                // Check if the scanner has an integer
                if (scanner.hasNextInt()) {
                    // Read the binary input and add it to the running sum
                    int input = scanner.nextInt();
                    runningSum += input;

                    // Print the running sum in binary
                    System.out.println("Running sum: " + Integer.toBinaryString(runningSum));
                } else {
                    // Handle invalid input
                    System.out.println("Invalid input. Please enter a valid binary number.");
                    scanner.next(); // Consume the invalid input
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                break; // Break the loop if an unexpected error occurs


            }
        }
    }
}
