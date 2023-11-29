import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        String csvFile = "Covid-19 Twitter Dataset (Apr-Jun 2020).csv"; // Replace with your CSV file path

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                Sentence sentence = Sentence.convertLine(line);
                if (sentence != null) {
                    System.out.println("Text: " + sentence.getText());
                    System.out.println("Author: " + sentence.getAuthor());
                    System.out.println("Timestamp: " + sentence.getTimestamp());
                    System.out.println(); // Adding a blank line for better readability
                } else {
                    // Optional: Handle invalid data or simply skip
                    // System.out.println("Invalid data: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
