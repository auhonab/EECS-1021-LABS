import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import java.io.IOException;

public class LABFPART1 {
    public static void main(String[] args) throws IOException {
        String myPort = "COM5";
        IODevice myGroveBoard = new FirmataDevice(myPort);
        try {
            myGroveBoard.start();
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();

            var myLED = myGroveBoard.getPin(4);
            myLED.setMode(Pin.Mode.OUTPUT);

            for (int i = 0; i < 6; i++) {

                myLED.setValue(1);
                Thread.sleep(2000);

                myLED.setValue(0);
                Thread.sleep(2000);
            }
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        } finally {
            myGroveBoard.stop();
            System.out.println("Board stopped.");
        }
    }
}