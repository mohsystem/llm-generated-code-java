package gemini.task92;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class Task92Test {

    // Helper class to simulate the shared resource in Java
    static class SharedResource {
        private int currentCounter;
        private final int maxCounter;
        private final Object lock;

        public SharedResource(int maxCounter) {
            this.maxCounter = maxCounter;
            this.currentCounter = 0;
            this.lock = new Object();
        }

        public void accessResource(int threadId) {
            if (currentCounter <= maxCounter) {
                synchronized (lock) {
                    if (currentCounter < maxCounter) {
                        currentCounter++;
                        System.out.println("Thread " + threadId + " is accessing currentCounter: " + currentCounter);
                    }
                }
            }
        }

        public int getCurrentCounter() {
            return currentCounter;
        }
    }

    @Test
    void testTask92() throws InterruptedException {
        int maxCounter = 5;
        int numThreads = 10;
        SharedResource sharedResource = new SharedResource(maxCounter);

        // Using CountDownLatch to wait for all threads to finish
        CountDownLatch latch = new CountDownLatch(numThreads);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Creating threads to access the shared resource
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            executor.submit(() -> {
                sharedResource.accessResource(threadId);
                latch.countDown();  // Decrement latch after thread finishes
            });
        }

        // Waiting for all threads to finish
        latch.await();
        executor.shutdown();

        // Check if currentCounter does not exceed maxCounter
        assertTrue(sharedResource.getCurrentCounter() <= maxCounter, "The counter exceeded the maximum limit.");
    }
}
