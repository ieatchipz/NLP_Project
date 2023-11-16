import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        String csvFile = "Covid-19 Twitter Dataset (Apr-Jun 2020).csv"; // Replace with your CSV file path

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Assuming the first line is a header, read and discard it
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Assuming CSV format: favorite_count, retweet_count, created_at, hashtags, original_author, user_mentions, place, clean_tweet
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (data.length >= 8) {
                    Sentence sentence = new Sentence(data[7], data[4], data[2]);
                    System.out.println(sentence.toString());
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
