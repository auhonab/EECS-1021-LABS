import org.firmata4j.Pin;
import java.util.TimerTask;

public class ButtonTask extends TimerTask {
    private final Pin myPin;

    ButtonTask(Pin pin) {
        this.myPin = pin;
    }

    @Override
    public void run() {
        System.out.println("value : " + myPin.getValue());
    }
}