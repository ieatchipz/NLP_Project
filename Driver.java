import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map; //place with imports
import java.util.Collections; //place with imports
import java.util.Comparator;


public class Driver{

  private static void readTwitterData(ArrayList<Sentence> tweets){

	
    int ctr = 0;
    try{
      //open the csv file for reading
      File file = new File("covid_10K.csv");
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
    //run a for loop that rips out anything that is blank

    public static HashMap<String, Integer> printTopWords(ArrayList<Sentence> sentences){
    HashMap<String,Integer> wordCounts = new HashMap<String,Integer>();
    for(int i = 0; i < sentences.size(); i++){
      Sentence sentence = sentences.get(i);
      ArrayList <String> words = sentence.splitSentence();
      for(int j = 0; j < words.size(); j++) {
        if(wordCounts.get(words.get(j)) != null){
        Integer count = wordCounts.get(words.get(j));
        count = count + 1;
        wordCounts.put(words.get(j), count);
       } else 
        wordCounts.put(words.get(j), (Integer) 1);
        
      }
    } 
    return wordCounts; 
    }

  
  public static void main(String[] args){
    ArrayList <Sentence> sentences = new ArrayList<Sentence>();


    


    readTwitterData(sentences);



	
    // System.out.println(sentences.toString());
    HashMap<String, Integer> sjHash = printTopWords(sentences); //calling method inside main, named it "sjHash" for "salsa, jood" lol
    // System.out.println(sjHash.toString());
    Map.Entry<String, Integer> maxEntry = null;
    for (Map.Entry<String, Integer> entry : sjHash.entrySet())
        if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            maxEntry = entry;
    int maxValueLen = maxEntry.getValue().toString().length();
    ArrayList <String> results = new ArrayList<String>();
    for (Map.Entry set : sjHash.entrySet()){
        String value = set.getValue().toString();
        while(value.length() < maxValueLen)
            value = " " + value;
        results.add(value + " of " + set.getKey());
    }
    Collections.sort(results);
    Collections.reverse(results);
    for (int i = 0; i < results.size() && i < 100; i++)
        System.out.println(results.get(i));

       /*  for(int i = 0; i < sentences.size(); i++){
          if(!sentences.get(i).getText().equals(" ")) {
              //System.out.println(sentences.get(i).getText());
              //System.out.println(sentences.get(i).getSentiment());
              System.out.println(sentences.get(i).getSentiment());
          }
      } */


      for (int i = 0; i < sentences.size(); i++) {
				Sentence texter = sentences.get(i);
				if (!(sentences.get(i).getText().equals(" "))) {
					System.out.println(texter.getSentiment());
				} 
			}
		}
}

/* 
			for (int i = 0; i < sentences.size(); i++) {

				Sentence texter = sentences.get(i);

				if (!(sentences.get(i).getText().equals(" "))) {
					System.out.println(texter.getSentiment());
          System.out.println("Sentiment Score: " + texter.getSentiment());
            }
				} 
			}
		}
*/
  
//add a method that filters dates and prints out sentiement for each year 
//have it in the for loop that prints out the sentiement for each sentence but make an if statement that
//prints it out within date ranges
//for (int i = 0; i < sentences.size(); i++) {
//if(sentences.get(i).keep("year")==true)
//sum+= System.out.println(sentences.get(i).getsentiment())

// average sum 

//A date range such as "May 31 2009-Jun 02 2009" if you are using tweets, or

// (ts > startDate && ts < endDate)
// return true 
  

