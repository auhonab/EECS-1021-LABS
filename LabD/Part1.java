package eecs1021;

import java.util.Random;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {

        final int UPPER_BOUND = 11;

        Random random = new Random();
        int target = random.nextInt(UPPER_BOUND) + 1; // Random number in range (0, UPPER_BOUND].


        Scanner scanner = new Scanner(System.in);

        int guess;
        int counter = 0;
        System.out.println(target);

        while (true) {

            System.out.print("Enter a guess: ");

            guess = scanner.nextInt();
            counter++;


            if (guess == target) {
                System.out.println("Correct! Took " + counter + " guesses");
                break;
            } else if (guess > target) {
                System.out.println("Guess is higher than answer\n");
            } else {
                System.out.println("Guess is less than answer\n");
            }
        }

        scanner.close();

    }
}
