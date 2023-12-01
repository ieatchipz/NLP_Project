public class Sentence {
	private String text;
	private String author;
	private String timestamp;

	public Sentence(String text, String author, String timestamp) {
		this.text = text;
		this.author = author;
		this.timestamp = timestamp;
	}

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public static Sentence convertLine(String line) {
		String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); //https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes

		if (data.length >= 8) {
			String text = data[7].replaceAll("^\"|\"$", ""); 
			String author = data[4].replaceAll("^\"|\"$", "");
			String timestamp = convertTimestamp(data[2].replaceAll("^\"|\"$", ""));

			return new Sentence(text, author, timestamp);
		}

		return null; 
	}

	private static String convertTimestamp(String timestamp) {
		/*pls have mercy*/ 
		try {
			java.text.SimpleDateFormat originalFormat = new java.text.SimpleDateFormat("M/d/yy hh:mm a");
			java.text.SimpleDateFormat targetFormat = new java.text.SimpleDateFormat("MMMM dd yyyy");
			java.util.Date date = originalFormat.parse(timestamp);
			return targetFormat.format(date); //https://stackoverflow.com/questions/3469507/how-can-i-change-the-date-format-in-java
		} catch (Exception eee) {
			return timestamp;
		} 
	}
}