import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Sentence {
    private String text;
    private String author;
    private String timestamp;

    public Sentence(String text, String author, String timestamp) {
        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }

    public String toString() {
        return "{author:" + author + ", sentence:\"" + text + "\", timestamp:\"" + timestamp + "\"}";
    }
}

