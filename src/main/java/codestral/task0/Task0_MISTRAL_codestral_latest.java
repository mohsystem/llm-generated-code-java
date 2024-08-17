package codestral.task0;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task0_MISTRAL_codestral_latest {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        File directory = new File("testing/task0/shared_directory");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                executor.submit(() -> processFile(file));
            }
        }
        executor.shutdown();
    }

    private static void processFile(File file) {
        lock.lock();
        try {
            System.out.println("Processing file: " + file.getName());
            // Add your file processing logic here
        } finally {
            lock.unlock();
        }
    }
}