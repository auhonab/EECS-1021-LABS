import org.firmata4j.Pin;
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;
import java.util.TimerTask;

public class PotTask extends TimerTask {
    private final SSD1306 myOledDisplay;
    private final Pin potPin;

    public PotTask(SSD1306 display, Pin pin) {
        this.myOledDisplay = display;
        this.potPin = pin;
    }

    @Override
    public void run() {
        try {
            int potValue = (int) potPin.getValue(); // Read potentiometer value
            System.out.println("Potentiometer Value: " + potValue); // Print to console

            // Draw on OLED
            MonochromeCanvas canvas = myOledDisplay.getCanvas();
            canvas.clear();
            canvas.drawString(10, 10, "Pot: " + potValue);
            canvas.drawLine(0, 30, (potValue * 128) / 1023, 30, MonochromeCanvas.Color.BRIGHT);
            myOledDisplay.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
