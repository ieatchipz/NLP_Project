public class ExtractTest {
	public static void main(String[] args) {

		String line = "0,0,11/10/21 12:00 AM,,salsa,,\"Paterson, Jersey\",hi im salsa";
		Sentence expected = new Sentence("hi im salsa", 
			"salsa", "November 10 2021");
		Sentence result = Sentence.convertLine(line);
		System.out.println("test1: " + expected.getText().equals(result.getText()));
		System.out.println("test2: " + expected.getAuthor().equals(result.getAuthor()));
		System.out.println("test3: " + expected.getTimestamp().equals(result.getTimestamp()));

		line = "0,0,11/10/21 12:00 AM,,jood,,riyadh,hi im jood";
		expected = new Sentence("hi im jood", 
			"jood", "November 10 2021");
		result = Sentence.convertLine(line);
		System.out.println("test4: " + expected.getText().equals(result.getText()));
		System.out.println("test5: " + expected.getAuthor().equals(result.getAuthor()));
		System.out.println("test6: " + expected.getTimestamp().equals(result.getTimestamp()));
	}
}