package eecs1021;

import java.util.Scanner;
// LAB A
public class myclass {
    public static void main(String[] args) {
        System.out.print("What is your name? ");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.println("Hello, " + name.toUpperCase());


        scanner.close();
    }
}