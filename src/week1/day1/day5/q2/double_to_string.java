package week1.day1.day5.q2;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class double_to_string {
    public static void main(String[] args) {
        // Data to be written to the file
        double[] numbers = {
                97.59780253225763, 23.705044359023198, 72.97025259152822, 18.986484094410137,
                77.56528079180427, 88.5456385076513, 59.09494795452861, 72.71304984780839,
                80.0202893029642, 29.58427968260707, 74.66713563267237, 27.40345943374961,
                15.990164966686493, 58.852582668688534, 45.58743329596889, 77.2227556103568,
                53.49035808405568, 93.5583604428736, 35.09314691785803, 9.812059847790467,
                51.438605600928376, 6.081908597641594, 2.604194278086147, 99.43752090812772,
                20.355993598952395
        };

        File file = new File("data.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write each double value to the file as a string with two decimal places
            for (double number : numbers) {
                writer.write(Double.toString(number));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("error");
        }

        List<Double> doubles = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                doubles.add(Double.parseDouble(line));
            }
            reader.close();
            System.out.println("data read is");
            for(double number : doubles){
                System.out.println(number);
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
