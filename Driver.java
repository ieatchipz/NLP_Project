import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map; //place with imports
import java.util.Collections; //place with imports


public class Driver{

  private static void readTwitterData(ArrayList<Sentence> tweets){

	
    int ctr = 0;
    try{
      //open the csv file for reading
      File file = new File("./covid_10K.csv");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;

      //loop through each line in the csv

      while ((line = reader.readLine()) != null){
        String strippedLine = line.strip(); //cut off the newline from the line read in
        Sentence sentence = Sentence.convertLine(strippedLine);
        tweets.add(sentence);
        ctr++;
      }
    }catch(Exception e){
        e.printStackTrace();
        System.out.println(ctr);
    }
	}

  public static HashMap<String, Integer> printTopWords(ArrayList<Sentence> sentences) { //needs to go outside of main, new
    HashMap<String, Integer> wordCount = new HashMap<>();
    for (Sentence sentence : sentences) {
      ArrayList<String> words = sentence.splitSentence();

      for (String word : words) {
          wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }
  } //end of new

  return wordCount;

  }

  public static void main(String[] args){
    ArrayList <Sentence> sentences = new ArrayList<Sentence>();

    //solution for Twitter data
    readTwitterData(sentences);

	
    for (Sentence sentence : sentences) { //this loop prints out the elements inside of the "splitSentence method"
        ArrayList<String> words = sentence.splitSentence();
        System.out.println("Tweet = " + sentence.getText());
    	for (String word : words) {
            System.out.println("Word = " + word);
      }
    }
  

  HashMap<String, Integer> sjHash = printTopWords(sentences); //calling method inside main, named it "sjHash" for "salsa, jood" lol

  Map.Entry<String, Integer> maxEntry = null; //start of copied code from CS1111 website
  for (Map.Entry<String, Integer> entry : sjHash.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
          maxEntry = entry;
      }
  }

  int maxValueLen = maxEntry.getValue().toString().length();
  ArrayList<String> results = new ArrayList<>();
  for (Map.Entry<String, Integer> set : sjHash.entrySet()) {
      String value = set.getValue().toString();
      while (value.length() < maxValueLen) {
          value = " " + value;
      }
      results.add(value + " of " + set.getKey());
  }

  Collections.sort(results);
  Collections.reverse(results);
  for (int i = 0; i < results.size() && i < 100; i++) {
      System.out.println(results.get(i)); //end of copied code from CS1111 website
  }
}



}
