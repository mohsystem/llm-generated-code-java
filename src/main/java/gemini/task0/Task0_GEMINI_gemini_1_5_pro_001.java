package gemini.task0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task0_GEMINI_gemini_1_5_pro_001 {

    public static void main(String[] args) {
        // Directory containing the files to process
        String directoryPath = "/path/to/directory";

        // Create a thread pool for concurrent processing
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Process each file in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Create a Runnable task to process the file
                    Runnable task = () -> {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                // Process the file contents here
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    };

                    // Submit the task to the thread pool
                    executor.execute(task);
                }
            }
        }

        // Shut down the thread pool
        executor.shutdown();

        // Wait for all tasks to complete
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}