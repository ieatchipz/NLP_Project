import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

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

  
  public static void main(String[] args){
    ArrayList <Sentence> sentences = new ArrayList<Sentence>();

    //solution for Twitter data
    readTwitterData(sentences);


    for(Sentence sentence : sentences) {
      System.out.println(sentence); //print out results
  }

  

  }

}