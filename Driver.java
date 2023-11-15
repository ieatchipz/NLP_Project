public class Driver {
    public static void main(String[] args) {
        String csvFile = "Covid-19 Twitter Dataset (Apr-Jun 2020).csv"; // Replace with your CSV file path

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming CSV format: text, author, timestamp
                String[] data = line.split(",");
                if (data.length >= 3) {
                    Sentence sentence = new Sentence(data[0], data[1], data[2]);
                    System.out.println(sentence.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}