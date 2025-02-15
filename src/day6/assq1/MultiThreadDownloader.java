/*package day6.assq1;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadDownloader {
    public static void main(String[] args) {
        String inputFile = "input.txt"; // File containing URLs
        String outputFolder = "downloads"; // Output folder for downloads
        int threadCount = 5; // Number of threads

        // Create output folder if it doesn't exist
        try {
            Files.createDirectories(Paths.get(outputFolder));
        } catch (IOException e) {
            System.err.println("Failed to create output folder: " + e.getMessage());
            return;
        }

        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // Read URLs from input file and assign tasks to threads
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String url;
            while ((url = br.readLine()) != null) {
                executor.submit(() -> downloadFile(url, outputFolder));
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }

        // Shut down the executor
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all tasks to finish
        }

        System.out.println("All files downloaded.");
    }

    private static void downloadFile(String fileURL, String outputFolder) {
        try {
            URL url = new URL(fileURL);
            String fileName = fileURL.substring(fileURL.lastIndexOf('/') + 1); // Extract file name
            InputStream inputStream = url.openStream();
            FileOutputStream outputStream = new FileOutputStream(outputFolder + File.separator + fileName);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();
            System.out.println("Downloaded: " + fileName);
        } catch (IOException e) {
            System.err.println("Failed to download: " + fileURL + " - " + e.getMessage());
        }
    }
}
*/