package eecs1021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        String csvFile = "Part2_CO2_DataLog_Modified_short.csv";
        String line;
        String csvSplitBy = ",";
        ArrayList<String> temperatureList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] elements = line.split(csvSplitBy);

                if (elements.length > 4) {
                    temperatureList.add(elements[4].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Temperature data from the CSV file: " + temperatureList);
        System.out.println("Size of ArrayList: " + temperatureList.size());

        double sum = 0.0;
        int count = 0;

        for (String temp : temperatureList) {
            try {
                sum += Double.parseDouble(temp);
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature value: " + temp);
            }
        }

        if (count > 0) {
            double average = sum / count;
            System.out.println("Average temperature: " + average);
        } else {
            System.out.println("No valid temperature data to calculate average.");
        }
    }
}