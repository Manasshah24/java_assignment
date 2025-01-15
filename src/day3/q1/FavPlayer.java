package day3.q1;
import java.io.*;

public class FavPlayer {
    public static void main(String[] args) {
        File inputFile = new File("players.jpg");
        File outputFile = new File("output.jpg");

        try (FileReader reader = new FileReader(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {

            int c;
            while ((c = reader.read()) != -1) {  // Corrected this line
                writer.write(c);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
