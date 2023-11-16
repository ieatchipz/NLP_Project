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
		} catch (IOException eee) {
			eee.printStackTrace();
		}
	}
}
// for political: hw 5 problem 8 convert line method 

//for covid: 
//way 1: in excel, force it to put double quotes around everything (reformatting file to have double quotes) 
//Make sure to submit with every file you submit it so it is updated
//double comma: no data given
// way 2: algorithm, write a while loop that starts at the beg stop everytime theres a comma and empty basket 
//-> if after a comma there is a double quote, keep reading till theres another double quote 
//(flag that turns on if theres a double quote and munches everything till the next double quote)
//way 3:
//-> chops up string into all pieces and create a sentence object with all three
//that the method will return 





//

//copy out tester test case and change the inputs and outpus to test these two things (tests cases for twitter) 
//use .split to split date up 