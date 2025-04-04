import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.ssd1306.MonochromeCanvas;
import java.io.IOException;

public class ButtonListen implements IODeviceEventListener {
    private final Pin buttonPin;
    private final Pin potPin;
    private final SSD1306 oled;
    private final MonochromeCanvas canvas;

    public ButtonListen(Pin buttonPin, Pin potPin, SSD1306 oled, MonochromeCanvas canvas) {
        this.buttonPin = buttonPin;
        this.potPin = potPin;
        this.oled = oled;
        this.canvas = canvas;
    }

    @Override
    public void onPinChange(IOEvent event) {
        if (event.getPin().getIndex() == buttonPin.getIndex()) {
            try {
                long buttonState = buttonPin.getValue();
                if (buttonState == 1) { // Button is pressed
                    // Read the potentiometer value
                    long potValue = potPin.getValue();
                    System.out.println("Potentiometer value: " + potValue);

                    // Clear the OLED display
                    canvas.clear();

                    // Display the potentiometer value on the OLED
                    canvas.drawString(0, 0, "Pot: " + potValue);


                    // Update the display
                    oled.display(); // Call display() on the SSD1306 object
                }
            } catch (Exception e) {
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