import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		String csvFile = "Covid-19 Twitter Dataset (Apr-Jun 2020).csv"; 

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			String line;
			ArrayList<Sentence> finalList = new ArrayList<Sentence>();

			while ((line = br.readLine()) != null) {
				Sentence newSentence = Sentence.convertLine(line);
				finalList.add(newSentence);
				   
					
			} 
		} catch (FileNotFoundException eee) {
			eee.printStackTrace();
		} catch (IOException eee) {
			eee.printStackTrace();
		} 
	} 
} 
