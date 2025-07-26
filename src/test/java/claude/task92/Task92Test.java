package claude.task92;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;

public class Task92Test {

    @Test
    public void testSharedResourceAccess() throws InterruptedException {
        int maxCounter = 10;
        int numThreads = 5;
        SharedResource sharedResource = new SharedResource(maxCounter);

        // Capture the output
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));

        // Create and start the threads
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new ResourceAccessThread(sharedResource, i);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Check the output and ensure that it follows the expected pattern
        String output = capturedOutput.toString();
        int expectedCounter = 1;
        AtomicInteger actualCounter = new AtomicInteger(0);

        // Check the output and validate the counter values
        for (int i = 0; i < numThreads; i++) {
            String threadOutput = "Thread " + i + " accessing. Current counter: ";
            int index = output.indexOf(threadOutput);

            while (index != -1) {
                int counterValueStart = index + threadOutput.length();
                int counterValueEnd = output.indexOf("\n", counterValueStart);
                int counterValue = Integer.parseInt(output.substring(counterValueStart, counterValueEnd).trim());

                // Ensure the counter does not exceed the maxCounter and increments as expected
                assertTrue(counterValue <= maxCounter, "Counter exceeded maxCounter");
                assertTrue(counterValue > actualCounter.get(), "Counter should be incrementing");

                actualCounter.set(counterValue);
                index = output.indexOf(threadOutput, index + 1);
            }
        }

        // Ensure the counter value does not exceed the maxCounter after all threads have finished
        assertTrue(actualCounter.get() <= maxCounter, "Final counter value exceeded maxCounter");
    }
}
