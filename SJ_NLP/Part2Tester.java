public class Part2Tester{

	public static void main(String[] args){



		// Test cases for Twitter COVID19 dataset
		String line = "0,119,4/19/20 12:00 AM,,agostinhozinga,,\"London, England\",taiwan vice presid chen chien jen countri fight covid19";
		Sentence expected = new Sentence("taiwan vice presid chen chien jen countri fight covid19", 
			"agostinhozinga", "April 19 2020");
		Sentence result = Sentence.convertLine(line);
		System.out.println("test1: " + expected.getText().equals(result.getText()));
		System.out.println("test2: " + expected.getAuthor().equals(result.getAuthor()));
		System.out.println("test3: " + expected.getTimestamp().equals(result.getTimestamp()));

		line = "0,0,4/22/20 12:00 AM,NWILife,NWINews,,Northwest Indiana,horizon bank donat urban leagu covid19 outreach";
		expected = new Sentence("horizon bank donat urban leagu covid19 outreach", 
			"NWINews", "April 22 2020");
		result = Sentence.convertLine(line);
		System.out.println("test4: " + expected.getText().equals(result.getText()));
		System.out.println("test5: " + expected.getAuthor().equals(result.getAuthor()));
		System.out.println("test6: " + expected.getTimestamp().equals(result.getTimestamp()));
	}
}
