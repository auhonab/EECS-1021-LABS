package eecs1021;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Part4 {
    public static void main(String[] args) {
        String csvFilePath = "ON_02HC024_daily_hydrometric_MODIFIED.csv";

        double totalDischargeRate = 0.0;
        int count = 0;

        try (FileReader myFileObject = new FileReader(csvFilePath);
             CSVReader csvReaderObject = new CSVReader(myFileObject, ',')) {

            String[] oneLineRecord;

            while ((oneLineRecord = csvReaderObject.readNext()) != null) {

                // Check if the array has enough columns
                if (oneLineRecord.length > 7) {

                    String dischargeRateString = oneLineRecord[7];
                    System.out.println("Discharge Rate (String): " + dischargeRateString);

                    // Convert the String into a Double
                    if (dischargeRateString != null && !dischargeRateString.trim().isEmpty()) {
                        try {
                            double dischargeRate = Double.parseDouble(dischargeRateString);
                            System.out.println("Discharge Rate (Double): " + dischargeRate);

                            totalDischargeRate += dischargeRate;
                            count++;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid discharge rate value: " + dischargeRateString);
                        }
                    } else {
                        System.out.println("Discharge rate string is empty or null.");
                    }
                } else {
                    System.out.println("Not enough columns in the record.");
                }
            }

            if (count > 0) {
                double averageDischargeRate = totalDischargeRate / count;
                System.out.println("Average Discharge Rate: " + averageDischargeRate);
            } else {
                System.out.println("No valid discharge rates found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}