import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.IODevice;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class LABFPART2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        var myUSBPort = "COM5";


        IODevice myGroveBoard = new FirmataDevice(myUSBPort);
        try {
            myGroveBoard.start();
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();

            Pin button = myGroveBoard.getPin(6);
            button.setMode(Pin.Mode.INPUT);


            var task = new ButtonTask(button);

            Timer timer = new Timer();
            timer.schedule(task, 0, 1000);
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}