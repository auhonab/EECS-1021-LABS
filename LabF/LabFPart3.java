import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class LabFPart3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        var myUSBPort = "COM5";

        IODevice myGroveBoard = new FirmataDevice(myUSBPort);
        try {
            myGroveBoard.start();
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();

            Pin ledPin = myGroveBoard.getPin(4);
            ledPin.setMode(Pin.Mode.OUTPUT);

            var task = new LEDTASK(ledPin);


            Timer timer = new Timer();
            timer.schedule(task, 0, 4000);
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}