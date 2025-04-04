import org.firmata4j.Pin;
import java.util.TimerTask;
import java.io.IOException;

public class LEDTASK extends TimerTask {
    private final Pin ledPin;
    private int ledState;

    // Constructor for LEDTask
    LEDTASK(Pin pin) {
        this.ledPin = pin;
        this.ledState = 0;
    }

    @Override
    public void run() {
        try {
            if (ledState == 0) {
                ledPin.setValue(1);
                ledState = 1;
                System.out.println("LED ON");
            } else {
                ledPin.setValue(0);
                ledState = 0;
                System.out.println("LED OFF");
            }
        } catch (IOException ex) {
            System.out.println("Error setting LED state: " + ex.getMessage());
        }
    }
}