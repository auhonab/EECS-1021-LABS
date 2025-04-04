import org.firmata4j.IODevice;
import org.firmata4j.IODeviceEventListener;
import org.firmata4j.IOEvent;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.I2CDevice;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.ssd1306.MonochromeCanvas;
import java.io.IOException;

public class Part2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String myPort = "COM5";
        IODevice myGroveBoard = new FirmataDevice(myPort);

        try {
            myGroveBoard.start();
            myGroveBoard.ensureInitializationIsDone();

            Pin buttonPin = myGroveBoard.getPin(Pins.D6);
            buttonPin.setMode(Pin.Mode.INPUT);

            Pin potPin = myGroveBoard.getPin(Pins.A0);
            potPin.setMode(Pin.Mode.ANALOG);

            I2CDevice i2cDevice = myGroveBoard.getI2CDevice(Pins.I2C0);
            SSD1306 oled = new SSD1306(i2cDevice, SSD1306.Size.SSD1306_128_64);
            MonochromeCanvas canvas = oled.getCanvas();

            oled.init();

            myGroveBoard.addEventListener(new ButtonListen(buttonPin, potPin, oled, canvas));

            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception ex) {
            System.out.println("Couldn't connect to the board: " + ex.getMessage());
        }
    }
}