import org.firmata4j.firmata.*; // Maven import Firmata4j & SLF4j on macOS & Windows
import org.firmata4j.IODevice;

public class Main {
    public static void main(String[] args) {
        String myPort = "COM5";
        IODevice myGroveBoard = new FirmataDevice(myPort);
        try {
            myGroveBoard.start();
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();
            myGroveBoard.stop();
            System.out.println("Board stopped.");
        } catch (Exception ex) {
            System.out.println("couldn't connect to board.");
        }
    }
}