import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import java.io.IOException;

public class ButtonListener implements IODeviceEventListener {
    private final Pin ledPin;
    private final Pin buttonPin;

    public ButtonListener(Pin ledPin, Pin buttonPin) {
        this.ledPin = ledPin;
        this.buttonPin = buttonPin;
    }

    @Override
    public void onPinChange(IOEvent event) {
        if (event.getPin().getIndex() == buttonPin.getIndex()) {
            try {
                long buttonState = buttonPin.getValue();

                long ledState = ledPin.getValue();
                if (ledState == 1) {
                    ledPin.setValue(0); // Turn LED off
                    System.out.println("Button pressed: LED turned OFF.");
                } else {
                    ledPin.setValue(1); // Turn LED on
                    System.out.println("Button pressed: LED turned ON.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onStart(IOEvent event) {}
    @Override
    public void onStop(IOEvent event) {}
    @Override
    public void onMessageReceive(IOEvent event, String message) {}
}