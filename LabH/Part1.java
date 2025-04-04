import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String myPort = "COM5";
        IODevice myGroveBoard = new FirmataDevice(myPort);

        try {
            myGroveBoard.start();
            myGroveBoard.ensureInitializationIsDone();

            Pin ledPin = myGroveBoard.getPin(Pins.D4);
            ledPin.setMode(Pin.Mode.OUTPUT);

            Pin buttonPin = myGroveBoard.getPin(Pins.D6);
            buttonPin.setMode(Pin.Mode.INPUT);

            myGroveBoard.addEventListener(new ButtonListener(ledPin, buttonPin));

            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception ex) {
            System.out.println("Couldn't connect to the board: " + ex.getMessage());
        }
    }
}