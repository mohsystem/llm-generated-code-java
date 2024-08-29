package gtp4o.task188;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task188Test {
    private FooBar fooBar;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        fooBar = new FooBar(0); // Initialize fooBar with a dummy value
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Redirect System.out to capture output
    }

    @Test
    void testFooBarWithNEquals1() throws InterruptedException {
        fooBar = new FooBar(1);
        executeFooBarTest(fooBar, "foobar");
    }

    @Test
    void testFooBarWithNEquals2() throws InterruptedException {
        fooBar = new FooBar(2);
        executeFooBarTest(fooBar, "foobarfoobar");
    }

    @Test
    void testFooBarWithNEquals3() throws InterruptedException {
        fooBar = new FooBar(3);
        executeFooBarTest(fooBar, "foobarfoobarfoobar");
    }

    @Test
    void testFooBarWithNEquals4() throws InterruptedException {
        fooBar = new FooBar(4);
        executeFooBarTest(fooBar, "foobarfoobarfoobarfoobar");
    }

    @Test
    void testFooBarWithNEquals5() throws InterruptedException {
        fooBar = new FooBar(5);
        executeFooBarTest(fooBar, "foobarfoobarfoobarfoobarfoobar");
    }

    @Test
    void testFooBarWithNEquals10() throws InterruptedException {
        fooBar = new FooBar(10);
        executeFooBarTest(fooBar, "foobar".repeat(10));
    }

    @Test
    void testFooBarWithNEquals100() throws InterruptedException {
        fooBar = new FooBar(100);
        executeFooBarTest(fooBar, "foobar".repeat(100));
    }

    @Test
    void testFooBarWithNEquals500() throws InterruptedException {
        fooBar = new FooBar(500);
        executeFooBarTest(fooBar, "foobar".repeat(500));
    }

    @Test
    void testFooBarWithNEquals750() throws InterruptedException {
        fooBar = new FooBar(750);
        executeFooBarTest(fooBar, "foobar".repeat(750));
    }

    @Test
    void testFooBarWithNEquals1000() throws InterruptedException {
        fooBar = new FooBar(1000);
        executeFooBarTest(fooBar, "foobar".repeat(1000));
    }

    private void executeFooBarTest(FooBar fooBar, String expectedOutput) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES); // Wait for all tasks to finish

        assertEquals(expectedOutput, outputStream.toString().trim()); // Assert captured output
    }
}
