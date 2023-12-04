import java.util.Arrays;
import java.util.ArrayList;

public class Sentence{
  private String text;
  private String author;
  private String timestamp;

  public Sentence(String text, String author, String timestamp){
    this.text = text;
    this.author = author;
    this.timestamp = timestamp;
  }

  public void setText(String text){
    this.text = text;
  }

  public String getText(){
    return text;
  }

  public void setAuthor(String author){
    this.author = author;
  }

  public String getAuthor(){
    return author;
  }

  public void setTimestamp(String timestamp){
    this.timestamp = timestamp;
  }

  public String getTimestamp(){
    return timestamp;
  }

  public String toString(){
    return "{author:" + author + ", sentence:\"" + text + "\", timestamp:\"" + timestamp + "\"}";
  }

  public ArrayList<String> splitSentence() { // (used HW8 as inspo) this part splits the sentence of the tweet into seperate words
	ArrayList<String> words = new ArrayList<>();
	String[] splitWords = this.text.split(" ");
	words.addAll(Arrays.asList(splitWords));
	return words;

	
}



    // for Twitter COVID dataset
    public static Sentence convertLine(String line){
      System.out.println(line);
      String[] pieces = new String[8];

      String basket = "";
      int ctr = 0;
      boolean startQuote = false;
      for(int i = 0; i < line.length(); i++){
        if (line.charAt(i) == ',' && startQuote == false){
          pieces[ctr] = basket;
          basket = "";
          ctr++;
        } else if (line.charAt(i) == '"'){
          startQuote = ! startQuote;
        } else{
          basket += line.charAt(i);
        }
      }
      pieces[ctr] = basket;
      System.out.println(Arrays.toString(pieces));
      String date = pieces[2];
      String username = pieces[4];
      String tweet = pieces[7];
  
      tweet = tweet.replaceAll("\"", ""); //removes double quotations from tweet
      tweet = tweet.replaceAll("\\.", ""); //removes periods from tweet
      tweet = tweet.replaceAll(",", ""); //removes commas from tweet
      tweet = tweet.replaceAll("!", ""); //removes exclamations from tweet
      // you could have included more/other punctuation here to remove as well
  
      //clean the date from "4/19/2020 0:00" to "April 19 2020"
      String [] datePieces = date.split(" ");
      String first = datePieces[0];
      datePieces = first.split("/");
      String month = datePieces[0];
      if (month.equals("1"))
        month = "January";
      else if (month.equals("2"))
        month = "February";
      else if (month.equals("3"))
        month = "March";
      else if (month.equals("4"))
        month = "April";
      else if (month.equals("5"))
        month = "May";
      else if (month.equals("6"))
        month = "June";
      else if (month.equals("7"))
        month = "July";
      else if (month.equals("8"))
        month = "August";
      else if (month.equals("9"))
        month = "September";
      else if (month.equals("10"))
        month = "October";
      else if (month.equals("11"))
        month = "November";
      else if (month.equals("12"))
        month = "December";

      date = month + " " + datePieces[1] + " " +  datePieces[2];
  
      String author = username;
      String text = tweet;
      return new Sentence(text, author, date);
    }
  }

