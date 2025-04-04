package eecs1021;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class Part3 {
    public static void main(String[] args) {

        String csvFilePath = "single_waterstation1_data_jan25.csv"; // Change this to your actual file path


        try (FileReader myFileObject = new FileReader(csvFilePath);
             CSVReader csvReaderObject = new CSVReader(myFileObject, ',')) {

            String[] oneLineRecord;


            while ((oneLineRecord = csvReaderObject.readNext()) != null) {

                System.out.println("Original: " + Arrays.toString(oneLineRecord));

                String cleanedLine = String.join(" ", oneLineRecord).replaceAll("\\s*,\\s*", " ").trim();

                System.out.println("Cleaned: " + cleanedLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
