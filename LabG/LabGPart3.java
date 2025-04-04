import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.IODevice;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;
import java.io.IOException;
import java.util.Timer;

public class LabGPart3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        String myUSB = "COM5";
        IODevice theArduinoObject = new FirmataDevice(myUSB);

        theArduinoObject.start();
        theArduinoObject.ensureInitializationIsDone();

        I2CDevice i2cObject = theArduinoObject.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED

        theOledObject.init();

        var task = new CountTask(theOledObject);
        Timer timer = new Timer();

        timer.schedule(task, 0, 1000);

        // Keep the program running
        Thread.sleep(Long.MAX_VALUE);
    }
}