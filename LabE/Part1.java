package eecs1021;

import java.io.FileInputStream;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {
        FileInputStream myFileObject = null;

        try {
            myFileObject = new FileInputStream("Part1TextFile.txt");
            int myData;

            while ((myData = myFileObject.read()) != -1) {
                char myCharacter = (char) myData;
                System.out.print(myCharacter);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            if (myFileObject != null) {
                myFileObject.close();
            }
        }
    }
}
