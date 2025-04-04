import	org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;
import	java.io.IOException;
import	java.util.Timer;
import org.firmata4j.Pin;


public class LabGPart4 {
    // Pin definitions (assuming Nano or UNO)
    static final int A0 = 14; // Potentiometer
    static final byte I2C0 = 0x3C; // OLED Display

    public static void main(String[] args) throws InterruptedException, IOException {
        var device = new FirmataDevice("COM5"); // Change to your serial port
        device.start();
        device.ensureInitializationIsDone();

        // Set up the OLED display
        SSD1306 myOledDisplay = new SSD1306(device.getI2CDevice(I2C0), SSD1306.Size.SSD1306_128_64);

        myOledDisplay.init();

        // Get the potentiometer pin
        Pin potPin = device.getPin(A0);
        potPin.setMode(Pin.Mode.ANALOG);

        // Set up the timer to read potentiometer value
        var task = new PotTask(myOledDisplay, potPin);
        new Timer().schedule(task, 0, 1000); // Runs every 1000ms
    }
}
