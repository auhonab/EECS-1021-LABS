package eecs1021;

import	java.util.Timer;
import	java.util.TimerTask;

public class PartB {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            private int counter = 0;

            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();
                System.out.println("Current time (ms): " + currentTime + ", Counter: " + counter);
                counter++;
            }
        }, 0, 1000);
    }
}
