package week1.day1.day3.q1;

import java.io.*;

public class method2_favplayer {
    public static void main(String[] args) {
        File inputFile = new File("messi.jpg");  // Source file
        File outputFile = new File("messi_copy_byte.jpg");  // Destination file

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            int byteData;
            while ((byteData = inputStream.read()) != -1) {  // Read byte by byte
                outputStream.write(byteData);  // Write byte to the new file
            }

            System.out.println("File copied using FileInputStream/FileOutputStream.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
