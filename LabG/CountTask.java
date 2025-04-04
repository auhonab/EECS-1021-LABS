import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;
import java.util.TimerTask;

public class CountTask extends TimerTask {
    private int countValue = 10; // Start countdown from 10
    private final SSD1306 theOledObject;

    // Constructor for CountTask
    public CountTask(SSD1306 aDisplayObject) {
        theOledObject = aDisplayObject;
    }

    @Override
    public void run() {
        // Get the canvas object to draw on the OLED
        MonochromeCanvas canvas = theOledObject.getCanvas();
        // Clear the canvas
        canvas.clear();
        // Draw the current countdown value at position (0, 0)
        canvas.drawString(0, 0, "Count: " + String.valueOf(countValue));
        // Update the OLED display
        theOledObject.display();

        // Update the countdown value
        if (countValue == 0) {
            countValue = 10; // Reset count to 10
        } else {
            countValue--; // Decrement count
        }
    }
}