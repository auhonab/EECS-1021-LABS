import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.IODevice;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;
import org.firmata4j.ssd1306.MonochromeCanvas;
import java.io.IOException;

public class LabGPart2 {
    public static void main(String[] args)
            throws InterruptedException, IOException
    {
        String myUSB = "COM5";
        IODevice theArduinoObject = new FirmataDevice(myUSB);
        theArduinoObject.start();
        theArduinoObject.ensureInitializationIsDone();
        I2CDevice i2cObject = theArduinoObject.getI2CDevice((byte) 0x3C);
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
        theOledObject.init();

        MonochromeCanvas canvas = theOledObject.getCanvas();

        canvas.clear();
        canvas.drawString(0, 0, "Auhona");
        theOledObject.display();
        Thread.sleep(4000);

        canvas.clear();
        canvas.drawString(0, 0, "Basu");
        theOledObject.display();
        Thread.sleep(4000);

        canvas.clear();
        canvas.drawString(0, 0, "220121539");
        theOledObject.display();
        Thread.sleep(4000);

        theArduinoObject.stop();
    }

}
