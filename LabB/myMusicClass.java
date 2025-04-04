package eecs1021;

import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import jm.constants.*;

import java.util.Scanner;

public class myMusicClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the first note's pitch and duration
        System.out.print("Enter the pitch (integer between 40 and 100): ");
        int pitch = scanner.nextInt();

        // Validate pitch input
        while (pitch < 40 || pitch > 100) {
            System.out.print("Invalid pitch. Please enter a pitch between 40 and 100: ");
            pitch = scanner.nextInt();
        }

        System.out.print("Enter the duration (float between 0.5 and 2.0): ");
        float duration = scanner.nextFloat();

        // Validate duration input
        while (duration < 0.5 || duration > 2.0) {
            System.out.print("Invalid duration. Please enter a duration between 0.5 and 2.0: ");
            duration = scanner.nextFloat();
        }

        // Play the melody using Play.midi() for each note
        Play.midi(new Note(pitch, duration)); // First note
        Play.midi(new Note(pitch + 2, duration)); // Second note (2 semitones higher)
        Play.midi(new Note(pitch + 4, duration)); // Third note (4 semitones higher)
        Play.midi(new Note(pitch + 5, duration)); // Fourth note (5 semitones higher)
        Play.midi(new Note(pitch + 4, duration)); // Fifth note (4 semitones higher)
        Play.midi(new Note(pitch + 2, duration)); // Sixth note (2 semitones higher)
        Play.midi(new Note(pitch, duration)); // Seventh note (original pitch)

        Play.midi(new Note(pitch + 5, duration)); // Eighth note (5 semitones higher)
        Play.midi(new Note(pitch + 5, duration)); // Ninth note (5 semitones higher)
        Play.midi(new Note(pitch + 4, duration)); // Tenth note (4 semitones higher)
        Play.midi(new Note(pitch + 4, duration)); // Eleventh note (4 semitones higher)
        Play.midi(new Note(pitch + 2, duration)); // Twelfth note (2 semitones higher)
        Play.midi(new Note(pitch + 2, duration)); // Thirteenth note (2 semitones higher)
        Play.midi(new Note(pitch, duration)); // Fourteenth note (original pitch)

        Play.midi(new Note(pitch + 5, duration)); // Fifteenth note (5 semitones higher)
        Play.midi(new Note(pitch + 5, duration)); // Sixteenth note (5 semitones higher)
        Play.midi(new Note(pitch + 4, duration)); // Seventeenth note (4 semitones higher)
        Play.midi(new Note(pitch + 4, duration)); // Eighteenth note (4 semitones higher)
        Play.midi(new Note(pitch + 2, duration)); // Nineteenth note (2 semitones higher)
        Play.midi(new Note(pitch + 2, duration)); // Twentieth note (2 semitones higher)
        Play.midi(new Note(pitch, duration)); // Twenty-first note (original pitch)

        // Close the scanner
        scanner.close();
    }
}
