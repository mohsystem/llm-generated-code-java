package gemini.task128;

import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class Task128Test {

    @RepeatedTest(100)
    public void testRandomIntegerRange() {
        Random random = new Random();
        int number = random.nextInt(10) + 1;
        assertTrue(number >= 1 && number <= 10, "Random integer not in [1,10]");
    }

    @RepeatedTest(100)
    public void testRandomDoubleRange() {
        Random random = new Random();
        double number = random.nextDouble();
        assertTrue(number >= 0.0 && number < 1.0, "Random double not in [0.0,1.0)");
    }

    @RepeatedTest(100)
    public void testRandomFruitSelection() {
        String[] fruits = {"apple", "banana", "cherry"};
        Random random = new Random();
        String fruit = fruits[random.nextInt(fruits.length)];
        assertTrue(
                fruit.equals("apple") || fruit.equals("banana") || fruit.equals("cherry"),
                "Unexpected fruit: " + fruit
        );
    }
}
