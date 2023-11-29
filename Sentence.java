public class Sentence {
    private String text;
    private String author;
    private String timestamp;

    // Constructor
    public Sentence(String text, String author, String timestamp) {
        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }

    // Getter methods
    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    // Convert CSV line to Sentence object
    public static Sentence convertLine(String line) {
        String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        if (data.length >= 8) {
            String text = data[7].replaceAll("^\"|\"$", ""); // Remove surrounding quotes if present
            String author = data[4].replaceAll("^\"|\"$", "");
            String timestamp = convertTimestamp(data[2].replaceAll("^\"|\"$", ""));

            return new Sentence(text, author, timestamp);
        }

        return null; // Return null if data is insufficient
    }

    // Helper method to convert date format
    private static String convertTimestamp(String timestamp) {
        try {
            java.text.SimpleDateFormat originalFormat = new java.text.SimpleDateFormat("M/d/yy hh:mm a");
            java.text.SimpleDateFormat targetFormat = new java.text.SimpleDateFormat("MMMM dd yyyy");
            java.util.Date date = originalFormat.parse(timestamp);
            return targetFormat.format(date);
        } catch (Exception e) {
            return timestamp; // Return original timestamp if parsing fails
        }
    }
}
