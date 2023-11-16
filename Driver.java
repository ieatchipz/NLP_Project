import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        String csvFile = "Covid-19 Twitter Dataset (Apr-Jun 2020).csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                 String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (data.length >= 8) {
                    Sentence sentence = new Sentence(data[7], data[4], data[2]);
                    System.out.println(sentence.toString());
                } 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
