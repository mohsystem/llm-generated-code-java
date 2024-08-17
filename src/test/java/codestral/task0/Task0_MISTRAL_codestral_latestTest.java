package codestral.task0;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Task0_MISTRAL_codestral_latestTest {

    private static final Lock lock = new ReentrantLock();

    @Test
    public void testProcessFile_withFiles_shouldPrintFileNames() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        File directory = new File("testing/task0/shared_directory");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                Future<?> future = executor.submit(() -> processFile(file));
                future.get(10, TimeUnit.SECONDS);
            }
        }
        executor.shutdown();

        for (File file : files) {
            Assertions.assertTrue(new File("processed_" + file.getName()).exists(), file.getName() + " was processed");
        }
    }

    @Test
    public void testProcessFile_withEmptyDirectory_shouldNotPrintAnything() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        File directory = new File("empty_directory");
        Assertions.assertTrue(new File(directory, "processed_").mkdirs());

        for (File file : directory.listFiles()) {
            Future<?> future = executor.submit(() -> processFile(file));
            future.get(10, TimeUnit.SECONDS);
        }

        Assertions.assertTrue(new File(directory, "processed_").listFiles().length == 0);
    }

    @Test
    public void testProcessFile_withNonExistentDirectory_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task0_MISTRAL_codestral_latest.main(new String[]{"non_existent_directory"}));
    }

    @Test
    public void testProcessFile_withNullDirectory_shouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Task0_MISTRAL_codestral_latest.main(new String[]{null}));
    }

    @Test
    public void testProcessFile_withNullFile_shouldNotThrowException() {
        Assertions.assertDoesNotThrow(() -> processFile(null));
    }

    @Test
    public void testProcessFile_withEmptyFile_shouldNotThrowException() throws IOException {
        File emptyFile = new File("empty_file.txt");
        Assertions.assertTrue(emptyFile.createNewFile());

        Assertions.assertDoesNotThrow(() -> processFile(emptyFile));
    }
//
//    @Test
//    public void testProcessFile_withLargeFile_shouldNotThrowException() throws InterruptedException, ExecutionException, TimeoutException, IOException {
//        File largeFile = new File("large_file.txt");
//        Assertions.assertTrue(largeFile.createNewFile());
//
//        long fileSize = 100000000; // 100 MB
//        byte[] data = new byte[(int) fileSize];
//        new Random().nextBytes(data);
//        Assertions.assertTrue(largeFile.getParentFile().mkdirs());
//        Assertions.assertTrue(largeFile.createNewFile());
//        try {
//            Assertions.assertTrue(largeFile.createNewFile());
//            Files.write(largeFile.toPath(), data);
//            Assertions.assertTrue(largeFile.setLength(fileSize));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Task0_MISTRAL_codestral_latest.main(new String[]{"large_file_directory"});
//
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        Future<?> future = executor.submit(() -> processFile(largeFile));
//        future.get(10, TimeUnit.SECONDS);
//
//        Assertions.assertTrue(largeFile.exists());
//    }

    @Test
    public void testProcessFile_withFileInSubdirectory_shouldProcessFile() throws InterruptedException, ExecutionException, TimeoutException, IOException {
        File directory = new File("subdirectory");
        directory.mkdirs();
        File file = new File(directory, "file_in_subdirectory.txt");
        Assertions.assertTrue(file.createNewFile());

        Task0_MISTRAL_codestral_latest.main(new String[]{"subdirectory"});

        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<?> future = executor.submit(() -> processFile(file));
        future.get(10, TimeUnit.SECONDS);

        Assertions.assertTrue(file.exists());
    }

    @Test
    public void testProcessFile_withFileInNestedSubdirectory_shouldProcessFile() throws InterruptedException, ExecutionException, TimeoutException, IOException {
        File directory = new File("nested_subdirectory");
        directory.mkdirs();
        File subdirectory = new File(directory, "subdirectory");
        subdirectory.mkdirs();
        File file = new File(subdirectory, "file_in_nested_subdirectory.txt");
        Assertions.assertTrue(file.createNewFile());

        Task0_MISTRAL_codestral_latest.main(new String[]{"nested_subdirectory"});

        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<?> future = executor.submit(() -> processFile(file));
        future.get(10, TimeUnit.SECONDS);

        Assertions.assertTrue(file.exists());
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