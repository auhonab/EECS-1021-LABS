package eecs1021;

import java.util.Random;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        final int UPPER_BOUND = 22;
        Random random = new Random();

        int answer = random.nextInt(UPPER_BOUND) + 1;
        int lowerBound = 0;
        int upperBound = UPPER_BOUND;

        System.out.println("Starting the guessing game! The range is (" + lowerBound + ", " + upperBound + "]");

        while (true) {

            int guess = random.nextInt(upperBound - lowerBound) + lowerBound + 1;
            System.out.println("Guess: " + guess);

            if (guess == answer) {
                System.out.println("Correct");
                break;
            } else if (guess > answer) {
                System.out.println("guess > answer");
                upperBound = guess; // Adjust the upper bound
            } else {
                System.out.println("guess < answer");
                lowerBound = guess; // Adjust the lower bound
            }
        }
    }
}
